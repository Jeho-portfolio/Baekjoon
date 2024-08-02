import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int[] number = new int[20000001];
        for (int i = 0; i < 20000001; i++) {
            number[i] = 0;
        }

        int N = Integer.parseInt(br.readLine());
        String n = br.readLine();
        StringTokenizer st = new StringTokenizer(n);
        for (int i = 0; i < N; i++) {
            int index = Integer.parseInt(st.nextToken());
            number[index + 10000000] = number[index + 10000000] + 1;
        }

        int M = Integer.parseInt(br.readLine());
        String m = br.readLine();
        st = new StringTokenizer(m);
        for (int i = 0; i < M; i++) {
            int index = Integer.parseInt(st.nextToken());
            bw.write(number[index + 10000000] + " ");
        }

        br.close();
        bw.close();
    }
}