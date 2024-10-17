import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception	{
        int quarter = 25, dime = 10, nickel = 5, penny = 1;
        int q, d, n, p;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            q = 0;
            d = 0;
            n = 0;
            p = 0;

            int C = Integer.parseInt(br.readLine());

            q = C / quarter;
            C = C % quarter;
            d = C / dime;
            C = C % dime;
            n = C / nickel;
            C = C % nickel;
            p = C / penny;

            bw.write(q + " " + d + " " + n + " " + p + "\n");
        }

        br.close();
        bw.close();
    }
}