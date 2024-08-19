import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception	{
        String str = br.readLine();

        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        int size = str.length();
        for (int i = 0; i < size; i++) {
            String tmp = str.substring(i);
            queue.add(tmp);
        }

        while (!queue.isEmpty()) {
            bw.write(queue.poll() + "\n");
        }

        br.close();
        bw.close();
    }
}