import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception	{
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        String N = st.nextToken();
        int l = N.length();
        int B = Integer.parseInt(st.nextToken());

        long sum = 0;
        double x = 0;

        for (int i = l - 1; i >= 0; i--) {
            char ch = N.charAt(i);
            long p = (long) Math.pow(B, x);
            if (ch >= 'A' &&  ch <= 'Z') {
                long target = ch - 'A' + 10;
                p = p * target;
            } else {
                long target = ch - '0';
                p = p * target;
            }
            sum = sum + p;
            x = x + 1;
        }

        bw.write(sum + "\n");

        br.close();
        bw.close();
    }
}