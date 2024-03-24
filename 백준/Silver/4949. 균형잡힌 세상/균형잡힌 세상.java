import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String str = br.readLine();
            char[] chars = str.toCharArray();
            Stack<Character> stack = new Stack<>();
            boolean flag = true;

            if (chars[0] == '.') {
                break;
            } else {
                for (int i = 0; i < chars.length; i++) {
                    if (chars[i] == '(' || chars[i] == '[') {
                        stack.push(chars[i]);
                    } else if (chars[i] == ')') {
                        if (stack.isEmpty()) {
                            flag = false;
                            break;
                        } else {
                            char tmp = stack.pop();
                            if (tmp != '(') {
                                flag = false;
                                break;
                            }
                        }
                    } else if (chars[i] == ']') {
                        if (stack.isEmpty()) {
                            flag = false;
                            break;
                        } else {
                            char tmp = stack.pop();
                            if (tmp != '[') {
                                flag = false;
                                break;
                            }
                        }
                    }
                }
                if (!stack.isEmpty()) {
                    flag = false;
                }
                if (flag) {
                    bw.write("yes\n");
                } else {
                    bw.write("no\n");
                }
            }
        }

        bw.close();
        br.close();
    }
}