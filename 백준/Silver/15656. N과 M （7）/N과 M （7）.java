import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M;
    static int[] arr = new int[7];
    static boolean[] visited = new boolean[7];
    static int[] number;

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        number = new int[N];

        str = br.readLine();
        st = new StringTokenizer(str);
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(number);

        sequence(0);

        br.close();
        bw.close();
    }

    static void sequence(int k) throws IOException {
        if (k == M) {
            for (int i = 0; i < M; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[k] = number[i];
            sequence(k + 1);
        }
     }
}