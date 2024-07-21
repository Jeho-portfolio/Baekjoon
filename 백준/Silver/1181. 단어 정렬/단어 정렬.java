import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) {
                    return -2;
                } if (o1.length() == o2.length()) {
                    if (o1.compareTo(o2) < 0) {
                        return -1;
                    } else if (o1.compareTo(o2) == 0) {
                        return 1;
                    } else {
                        return 2;
                    }
                } else {
                    return 3;
                }
            }
        });

        for (int i = 0; i < N; i++) {
            queue.add(br.readLine());
        }

        LinkedHashSet<String> set = new LinkedHashSet<>();

        while (!queue.isEmpty()) {
            set.add(queue.poll());
        }

        Iterator<String> iterator = set.iterator();

        while (iterator.hasNext()) {
            bw.write(iterator.next() + "\n");
        }

        br.close();
        bw.close();
    }
}