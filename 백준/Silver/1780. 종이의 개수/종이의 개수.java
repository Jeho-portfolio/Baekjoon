import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][] paper;

    static int minusOne = 0;
    static int zero = 0;
    static int plusOne = 0;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cut(0, 0, N);

        bw.write(minusOne + "\n");
        bw.write(zero + "\n");
        bw.write(plusOne + "\n");

        br.close();
        bw.close();
    }

    static void cut(int r, int c, int size) {
        boolean check = true;
        int target = paper[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (paper[i][j] != target) {
                    check = false;
                }
            }
        }

        if (check) {
            if (target == 0) {
                zero = zero + 1;
            } else if (target == 1) {
                plusOne = plusOne + 1;
            } else {
                minusOne = minusOne + 1;
            }
            return;
        } else {
            size = size / 3;
            cut(r, c, size);
            cut(r, c + size, size);
            cut(r, c + (size * 2), size);
            cut(r + size, c, size);
            cut(r + size, c + size, size);
            cut(r + size, c + (size * 2), size);
            cut(r + (size * 2), c, size);
            cut(r + (size * 2), c + size, size);
            cut(r + (size * 2), c + (size * 2), size);
        }
    }
}