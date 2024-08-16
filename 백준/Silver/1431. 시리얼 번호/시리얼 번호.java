import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception	{
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) {
                    return -6;
                } else if (o1.length() == o2.length()) {
                    int first = 0;
                    for (int i = 0; i < o1.length(); i++) {
                        if (o1.charAt(i) >= '0' && o1.charAt(i) <= '9') {
                            first = first + o1.charAt(i) - '0';
                        }
                    }
                    int second = 0;
                    for (int i = 0; i < o2.length(); i++) {
                        if (o2.charAt(i) >= '0' && o2.charAt(i) <= '9') {
                            second = second + o2.charAt(i) - '0';
                        }
                    }

                    if (first < second) {
                        return -2;
                    } else if (first == second) {
                        if (o1.compareTo(o2) < 0) {
                            return -1;
                        } else if (o1.compareTo(o2) == 0) {
                            return 0;
                        } else {
                            return 1;
                        }
                    } else {
                        return 2;
                    }
                } else {
                    return 6;
                }
            }
        });

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            queue.add(br.readLine());
        }

        while (!queue.isEmpty()) {
            bw.write(queue.poll() + "\n");
        }

        br.close();
        bw.close();
    }
}