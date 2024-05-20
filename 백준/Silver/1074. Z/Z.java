import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int number = 0;

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int n = (int) Math.pow(2, N);

        count(r, c, n);

        bw.write(String.valueOf(number));

        br.close();
        bw.close();
    }

    static void count(int r, int c, int n) throws IOException {
        if (n == 1) {
            if (r < n && c >= n) {
                number = number + 1;
            }
            if (r >= n && c < n) {
                number = number + 2;
            }
            if (r >= n && c >= n) {
                number = number + 3;
            }
            return;
        }

        n = n / 2;
        if (r < n && c < n) {
            count(r % n, c % n, n);
        }
        if (r < n && c >= n) {
            number = number + (n * n);
            count(r % n, c % n, n);
        }
        if (r >= n && c < n) {
            number = number + (n * n * 2);
            count(r % n, c % n, n);
        }
        if (r >= n && c >= n) {
            number = number + (n * n * 3);
            count(r % n, c % n, n);
        }
    }
}