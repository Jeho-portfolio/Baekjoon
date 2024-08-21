import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception	{
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);

            int count = 0;

            int N = Integer.parseInt(st.nextToken());
            int[] a = new int[N];
            int M = Integer.parseInt(st.nextToken());
            int[] b = new int[M];

            String A = br.readLine();
            StringTokenizer sta = new StringTokenizer(A);
            for (int j = 0; j < N; j++) {
                a[j] = Integer.parseInt(sta.nextToken());
            }
            Arrays.sort(a);

            String B = br.readLine();
            StringTokenizer stb = new StringTokenizer(B);
            for (int j = 0; j < M; j++) {
                b[j] = Integer.parseInt(stb.nextToken());
            }
            Arrays.sort(b);

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (a[j] > b[k]) {
                        count = count + 1;
                    }
                }
            }

            bw.write(count + "\n");
        }

        br.close();
        bw.close();
    }
}