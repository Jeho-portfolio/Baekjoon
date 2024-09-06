import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static long[][] pn = new long[91][2];

    public static void main(String args[]) throws Exception   {
        int N = Integer.parseInt(br.readLine());

        pn[1][0] = 0;
        pn[1][1] = 1;

        for (int i = 2; i <= N; i++) {
            long zero = pn[i - 1][0];
            long one = pn[i - 1][1];

            long zeroCount = 0;
            long oneCount = 0;

            zeroCount = zeroCount + zero + one;
            oneCount = oneCount + zero;

            pn[i][0] = zeroCount;
            pn[i][1] = oneCount;
        }

        bw.write(String.valueOf(pn[N][0] + pn[N][1]));

        br.close();
        bw.close();
    }
}