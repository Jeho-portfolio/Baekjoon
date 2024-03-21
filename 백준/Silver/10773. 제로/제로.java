import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());

        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < K; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (tmp == 0) {
                if (!s.isEmpty()) {
                    s.pop();
                }
            } else {
                s.push(tmp);
            }
        }

        int sum = 0;
        while (!s.isEmpty()) {
            sum = sum + s.pop();
        }
        bw.write(String.valueOf(sum));

        bw.close();
        br.close();
    }
    
}