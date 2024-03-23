import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        str = br.readLine();
        st = new StringTokenizer(str);
        int count = 0;
        for (int i = 0; i < M; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            while (tmp != deque.peekFirst()) {
                int x = deque.indexOf(tmp);
                int middle = deque.size() / 2;
                if (x <= middle) {
                    deque.addLast(deque.pollFirst());
                    count = count + 1;
                } else {
                    deque.addFirst(deque.pollLast());
                    count = count + 1;
                }
            }
            deque.poll();
        }

        bw.write(String.valueOf(count));

        bw.close();
        br.close();
    }
}

