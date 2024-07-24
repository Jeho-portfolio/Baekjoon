import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        HashSet<Integer> set = new HashSet<>();

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        str = br.readLine();
        st = new StringTokenizer(str);
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            if (set.contains(target)) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }

        br.close();
        bw.close();
    }
}