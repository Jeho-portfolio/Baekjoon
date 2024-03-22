import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        Stack<Number> s = new Stack<>();

        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (s.isEmpty()) {
                bw.write("0 ");
                s.push(new Number(i + 1, tmp));
            } else {
                while (!s.isEmpty() && s.peek().height < tmp) {
                    s.pop();
                }
                if (s.isEmpty()) {
                    bw.write("0 ");
                } else {
                    bw.write(String.valueOf(s.peek().index) + " ");
                }
                s.push(new Number(i + 1, tmp));
            }
        }

        bw.close();
        br.close();
    }
}

class Number {
    int index;
    int height;

    Number(int first, int second) {
        index = first;
        height = second;
    }
}