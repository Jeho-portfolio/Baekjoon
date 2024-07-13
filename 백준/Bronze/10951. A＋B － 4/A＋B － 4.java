import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        while (true) {
            String str = br.readLine();
            if (str == null) {
                break;
            } else {
                StringTokenizer st = new StringTokenizer(str);

                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                bw.write((A + B) + "\n");
            }
        }

        br.close();
        bw.close();
    }
}