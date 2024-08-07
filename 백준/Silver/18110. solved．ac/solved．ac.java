import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        int average = 0;

        double number = Math.round(N * 0.15);
        for (int i = 0; i < number; i++) {
            queue.poll();
        }
        while (queue.size() > number) {
            average = average + queue.poll();
        }

        average = (int) Math.round(average / (N - (number * 2)));

        bw.write(String.valueOf(average));

        br.close();
        bw.close();
    }
}