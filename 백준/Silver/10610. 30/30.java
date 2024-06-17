import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String str = br.readLine();

        int result = 0;
        boolean flag = false;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        while (true) {
            if (!str.isEmpty()) {
                String tmp = str.substring(0, 1);
                queue.add(Integer.parseInt(tmp));
                if (tmp.equals("0")) {
                    flag = true;
                }
                result = result + Integer.parseInt(tmp);
                result = result % 3;

                str = str.substring(1);
            } else {
                break;
            }
        }

        if (flag && result == 0) {
            while (!queue.isEmpty()) {
                bw.write(queue.poll() + "");
            }
        } else {
            bw.write("-1");
        }

        br.close();
        bw.close();
    }
}