import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception	{
        int n = Integer.parseInt(br.readLine());

        int[] wine = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        int[] max = new int[n + 1];
        if (n == 1) {
            max[1] = wine[1];
        } else if (n == 2) {
            max[2] = wine[1] + wine[2];
        } else if (n == 3) {
            max[1] = wine[1];
            max[2] = wine[1] + wine[2];
            max[3] = Math.max(wine[1] + wine[3], Math.max(wine[1] + wine[2], wine[2] + wine[3]));
        } else {
            max[1] = wine[1];
            max[2] = wine[1] + wine[2];
            max[3] = Math.max(wine[1] + wine[3], Math.max(wine[1] + wine[2], wine[2] + wine[3]));

            for (int i = 4; i <= n; i++) {
                max[i] = Math.max(max[i - 1], Math.max(max[i - 2] + wine[i], max[i - 3] + wine[i] + wine[i - 1]));
            }
        }

        bw.write(String.valueOf(max[n]));

        br.close();
        bw.close();
    }
}