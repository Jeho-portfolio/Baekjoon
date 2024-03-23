import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Stack<Building> s = new Stack<>();

        long count = 0;
        for (int i = 0; i < N; i++) {
            long h = Integer.parseInt(br.readLine());
            if (s.isEmpty()) {
                s.push(new Building(h));
            } else {
                if (h < s.peek().height) {
                    count = count + s.size();
                    s.push(new Building(h));
                } else {
                    while (!s.isEmpty() && h >= s.peek().height) {
                        s.pop();
                    }
                    count = count + s.size();
                    s.push(new Building(h));
                }
            }
        }

        bw.write(String.valueOf(count));


        bw.close();
        br.close();
    }
}

class Building {
    long height;
    Building(long first) {
        height = first;
    }
}