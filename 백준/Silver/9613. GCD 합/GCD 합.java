import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int t, n;
    static long sum;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);

            n = Integer.parseInt(st.nextToken());

            arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            sum = 0;

            for (int k = 0; k < n - 1; k++) {
                for (int l = k + 1; l < n; l++) {
                    long result = gcd(arr[k], arr[l]);
                    sum = sum + result;
                }
            }

            bw.write(sum + "\n");
        }

        br.close();
        bw.close();
    }

    static long gcd(long first, long second) {
        long max = Math.max(first, second);
        long min = Math.min(first, second);

        while (true) {
            long r = max % min;
            if (r == 0) {
                break;
            }

            max = min;
            min = r;
        }
        return min;
    }
}