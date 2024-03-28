import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            int length = str.length();
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < length; j++) {
                char c = str.charAt(j);
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    if (c == ')') {
                        if (stack.peek() == '(') {
                            stack.pop();
                        } else {
                            stack.push(c);
                        }
                    } else if (c == '(') {
                        stack.push(c);
                    }
                }
            }
            if (stack.isEmpty()) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }

        bw.close();
        br.close();
    }
}