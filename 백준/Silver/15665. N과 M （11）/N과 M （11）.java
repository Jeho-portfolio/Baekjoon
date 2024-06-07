import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M;
    static int[] arr = new int[8];
    static boolean[] visited = new boolean[8];
    static int[] number;
    static Set<String> result = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        number = new int[N];

        str = br.readLine();
        st = new StringTokenizer(str);
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(number);

        sequence(0);

        Iterator<String> iterator = result.iterator();
        while (iterator.hasNext()) {
            bw.write(iterator.next() + "\n");
        }

        br.close();
        bw.close();
    }

    public static void sequence(int k) {
        if (k == M) {
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < M; i++) {
                sb.append(arr[i] + " ");
            }
            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[k] = number[i];
            sequence(k + 1);
        }
    }
}