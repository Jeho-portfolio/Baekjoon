import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception	{
        while (true) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");

            float x = Float.parseFloat(st.nextToken());
            float y = Float.parseFloat(st.nextToken());

            if (x == 0 && y == 0) {
                bw.write("AXIS\n");
                break;
            } else {
                if (x == 0 || y == 0) {
                    bw.write("AXIS\n");
                } else {
                    if (x > 0 && y > 0) {
                        bw.write("Q1\n");
                    } else if (x < 0 && y > 0) {
                        bw.write("Q2\n");
                    } else if (x < 0 && y < 0) {
                        bw.write("Q3\n");
                    } else if (x > 0 && y < 0) {
                        bw.write("Q4\n");
                    }
                }
            }
        }

        br.close();
        bw.close();
    }
}