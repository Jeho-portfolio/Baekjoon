import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            String command = st.nextToken();

            if (command.equals("push")) {
                q.add(Integer.parseInt(st.nextToken()));
            } else if (command.equals("pop")) {
                if (q.isEmpty()) {
                    bw.write(String.valueOf(-1) + "\n");
                } else {
                    bw.write(String.valueOf(q.poll()) + "\n");
                }
            } else if (command.equals("size")) {
                bw.write(String.valueOf(q.size()) + "\n");
            } else if (command.equals("empty")) {
                if (q.isEmpty()) {
                    bw.write(String.valueOf(1) + "\n");
                } else {
                    bw.write(String.valueOf(0) + "\n");
                }
            } else if (command.equals("front")) {
                if (q.isEmpty()) {
                    bw.write(String.valueOf(-1) + "\n");
                } else {
                    bw.write(String.valueOf(q.peekFirst()) + "\n");
                }
            } else if (command.equals("back")) {
                if (q.isEmpty()) {
                    bw.write(String.valueOf(-1) + "\n");
                } else {
                    bw.write(String.valueOf(q.peekLast()) + "\n");
                }
            }
        }

        bw.close();
        br.close();
    }
}