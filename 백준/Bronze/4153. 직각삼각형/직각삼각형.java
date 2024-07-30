import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        while (true) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            if (a >= b && a >= c) {
                if (a * a == b * b + c * c) {
                    bw.write("right\n");
                } else {
                    bw.write("wrong\n");
                }
            } else if (b >= a && b >= c) {
                if (b * b == a * a + c * c) {
                    bw.write("right\n");
                } else {
                    bw.write("wrong\n");
                }
            } else {
                if (c * c == b * b + a * a) {
                    bw.write("right\n");
                } else {
                    bw.write("wrong\n");
                }
            }
        }

        br.close();
        bw.close();
    }
}