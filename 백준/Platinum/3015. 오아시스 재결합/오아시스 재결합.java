import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Integer.parseInt(br.readLine());
        Stack<Person> stack = new Stack<>();
        long count = 0;

        for (int i = 0; i < N; i++) {
            long tmp = Integer.parseInt(br.readLine());
            Person p = new Person(tmp, 1);

            if (stack.isEmpty()) {
                stack.push(p);
            } else {
                if (tmp < stack.peek().height) {
                    count = count + 1;
                    stack.push(p);
                } else {
                    while (!stack.isEmpty() && tmp >= stack.peek().height) {
                        if (tmp == stack.peek().height) {
                            long c = stack.pop().number;
                            p.number = p.number + c;
                            count = count + c;
                        } else {
                            count = count + stack.pop().number;
                        }
                    }
                    if (!stack.isEmpty()) {
                        count = count + 1;
                    }
                    stack.push(p);
                }
            }
        }

        bw.write(String.valueOf(count));

        bw.close();
        br.close();
    }
}

class Person {
    long height;
    long number;
    Person(long first, long second) {
        height = first;
        number = second;
    }
}