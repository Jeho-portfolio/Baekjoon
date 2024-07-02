import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        M = M - 45;
        if (M < 0) {
            M = M + 60;
            H = H - 1;
            if (H < 0) {
                H = 23;
            }
        }

        bw.write(H + " " + M);

        br.close();
        bw.close();
    }
}