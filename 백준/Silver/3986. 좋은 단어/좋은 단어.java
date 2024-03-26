import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            int length = str.length();
            for (int j = 0; j < length; j++) {
                char c = str.charAt(j);
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    if (stack.peek() == c) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }
            if (stack.isEmpty()) {
                count = count + 1;
            }
        }

        bw.write(String.valueOf(count));

        bw.close();
        br.close();
    }
}