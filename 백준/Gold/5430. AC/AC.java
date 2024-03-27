import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String command = br.readLine();
            int length = Integer.parseInt(br.readLine());
            String list = br.readLine();
            StringTokenizer st = new StringTokenizer(list, "[,]");
            LinkedList<Integer> l = new LinkedList<>();
            for (int j = 0; j < length; j++) {
                l.add(Integer.parseInt(st.nextToken()));
            }
            int commandLength = command.length();
            boolean flag = true, error = false;
            for (int k = 0; k < commandLength; k++) {
                char c = command.charAt(k);
                if (c == 'R') {
                    if (flag) {
                        flag = false;
                    } else {
                        flag = true;
                    }
                } else {
                    if (!l.isEmpty()) {
                        if (flag) {
                            l.pollFirst();
                        } else {
                            l.pollLast();
                        }
                    } else {
                        error = true;
                    }
                }
            }
            if (error) {
                bw.write("error\n");
                error = false;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                int lSize = l.size();
                for (int m = 0; m < lSize - 1; m++) {
                    if (flag) {
                        sb.append(String.valueOf(l.pollFirst()) + ",");
                    } else {
                        sb.append(String.valueOf(l.pollLast()) + ",");
                    }
                }
                if (!l.isEmpty()) {
                    sb.append(String.valueOf(l.poll()) + "]");
                } else {
                    sb.append("]");
                }

                bw.write(sb + "\n");
            }
        }

        bw.close();
        br.close();
    }
}