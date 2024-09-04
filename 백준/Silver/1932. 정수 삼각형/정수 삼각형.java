import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception	{
        int n = Integer.parseInt(br.readLine());

        int[][] triangle = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);

            int index = 1;
            while (st.hasMoreTokens()) {
                int target = Integer.parseInt(st.nextToken());
                triangle[i][index] = target;
                index = index + 1;
            }
        }

        int[][] sum = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            sum[n][i] = triangle[n][i];
        }

        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                int first = sum[i + 1][j];
                int second = sum[i + 1][j + 1];
                sum[i][j] = Math.max(first, second) + triangle[i][j];
            }
        }

        bw.write(sum[1][1] + "\n");

        br.close();
        bw.close();
    }
}