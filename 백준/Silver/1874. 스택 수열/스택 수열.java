import java.io.*;
import java.math.BigDecimal;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        StringBuilder sb = new StringBuilder("");

        Stack<Integer> s = new Stack<>();

        int index = 0;
        int number = 1;
        int flag = 1;

        while (index < N) {
            if (number < list[index]) {
                s.push(number);
                sb.append("+\n");
                number = number + 1;
            } else if (number == list[index]) {
                s.push(number);
                sb.append("+\n");
                s.pop();
                sb.append("-\n");
                index = index + 1;
                number = number + 1;
            } else if (s.peek() == list[index]) {
                s.pop();
                sb.append("-\n");
                index = index + 1;
            } else {
                flag = 0;
                break;
            }
        }

        if (flag == 1) {
            System.out.println(sb);
        } else {
            System.out.print("NO");
        }

        bw.close();
        br.close();

    }
}