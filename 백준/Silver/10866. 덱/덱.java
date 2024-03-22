import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            String tmp = st.nextToken();

            if (tmp.equals("push_front")) {
                int x = Integer.parseInt(st.nextToken());
                deque.addFirst(x);
            } else if (tmp.equals("push_back")) {
                int x = Integer.parseInt(st.nextToken());
                deque.addLast(x);
            } else if (tmp.equals("pop_front")) {
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(String.valueOf(deque.poll()) + "\n");
                }
            } else if (tmp.equals("pop_back")) {
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(String.valueOf(deque.pollLast()) + "\n");
                }
            } else if (tmp.equals("size")) {
                bw.write(String.valueOf(deque.size()) + "\n");
            } else if (tmp.equals("empty")) {
                if (deque.isEmpty()) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if (tmp.equals("front")) {
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(String.valueOf(deque.peekFirst()) + "\n");
                }
            } else if (tmp.equals("back")) {
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(String.valueOf(deque.peekLast()) + "\n");
                }
            }
        }

        bw.close();
        br.close();
    }
}