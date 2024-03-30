import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int length = str.length();
        Stack<Character> stack = new Stack<>();
        int tmp = 1, result = 0;
        boolean flag = false;

        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack.push(c);
                tmp = tmp * 2;
                flag = true;
            } else if (c == '[') {
                stack.push(c);
                tmp = tmp * 3;
                flag = true;
            } else if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    if (flag) {
                        result = result + tmp;
                    }
                    tmp = tmp / 2;
                    flag = false;
                } else {
                    stack.push(c);
                }
            } else if (c == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                    if (flag) {
                        result = result + tmp;
                    }
                    tmp = tmp / 3;
                    flag = false;
                } else {
                    stack.push(c);
                }
            }
        }

        if (stack.isEmpty()) {
            bw.write(String.valueOf(result));
        } else {
            bw.write("0");
        }

        bw.close();
        br.close();
    }
}