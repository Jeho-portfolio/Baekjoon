import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int resultMin = Integer.MAX_VALUE;
        int resultMax = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            resultMin = Math.min(resultMin, tmp);
            resultMax = Math.max(resultMax, tmp);
        }

        bw.write(resultMin + " " + resultMax);

        br.close();
        bw.close();
    }
}