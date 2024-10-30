import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception	{
        while (true) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            if (first == 0 && second == 0) {
                break;
            } else {
                if (first > second) {
                    if (first % second == 0) {
                        bw.write("multiple\n");
                    } else {
                        bw.write("neither\n");
                    }
                } else if (first < second) {
                    if (second % first == 0) {
                        bw.write("factor\n");
                    } else {
                        bw.write("neither\n");
                    }
                }
            }
        }

        br.close();
        bw.close();
    }
}