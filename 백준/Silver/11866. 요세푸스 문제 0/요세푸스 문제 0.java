import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        if (N == 1) {
            bw.write("<" + queue.poll() + ">");
        } else {
            int count = 0;
            while (!queue.isEmpty()) {
                int tmp = queue.poll();
                count = count + 1;

                if (count == K) {
                    if (queue.size() == N - 1) {
                        bw.write("<" + tmp + ", ");
                    } else {
                        if (!queue.isEmpty()) {
                            bw.write(tmp + ", ");
                        } else {
                            bw.write(tmp + ">");
                        }
                    }
                    count = 0;
                } else {
                    queue.add(tmp);
                }
            }
        }

        br.close();
        bw.close();
    }
}