import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int length = str.length();
        Stack<Character> stack = new Stack<>();
        int piece = 0;
        boolean flag = false;
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
                flag = true;
            } else {
                if (c == ')') {
                    if (stack.peek() == '(') {
                        if (flag) {
                            stack.pop();
                            piece = piece + stack.size();
                            flag = false;
                        } else {
                            stack.pop();
                            if (!flag) {
                                piece = piece + 1;
                            }
                            flag = false;
                        }
                    }
                } else {
                    stack.push(c);
                    flag = true;
                }
            }
        }
        bw.write(String.valueOf(piece));

        bw.close();
        br.close();
    }
}