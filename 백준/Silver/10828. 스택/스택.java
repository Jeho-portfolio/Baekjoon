import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number;
        String str;
        Stack<Integer> s = new Stack<>();

        number = Integer.parseInt(br.readLine());

        for (int i = 0; i < number; i++) {
            str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            if (st.nextToken().equals("push")) {
                s.add(Integer.parseInt(st.nextToken()));
            }

            if (str.equals("top")) {
                if (!s.isEmpty()) {
                    System.out.println(s.peek());
                }
                else {
                    System.out.println(-1);
                }
            }
            else if (str.equals("size")) {
                System.out.println(s.size());
            }
            else if (str.equals("empty")) {
                if (s.isEmpty()) {
                    System.out.println(1);
                }
                else {
                    System.out.println(0);
                }
            }
            else if (str.equals("pop")){
                if (!s.isEmpty()) {
                    System.out.println(s.pop());
                }
                else {
                    System.out.println(-1);
                }

            }
        }

        br.close();
    }
}
