import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int result = 1;
        for (int i = 0; i < K; i++) {
            result = result * N;
            N = N - 1;
        }
        for (int i = K; i >= 1; i--) {
            result = result / i;
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }
}