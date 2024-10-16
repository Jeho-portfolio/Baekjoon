import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception	{
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Stack<String> stack = new Stack<>();
        while (N > 0) {
            int tmp = N % B;
            if (tmp >= 10) {
                char target = (char) ((char) 'A' + tmp - 10);
                stack.push(String.valueOf(target));
            } else {
                stack.push(String.valueOf(tmp));
            }
            N = N / B;
        }

        while (!stack.isEmpty()) {
            bw.write(stack.pop());
        }

        br.close();
        bw.close();
    }
}