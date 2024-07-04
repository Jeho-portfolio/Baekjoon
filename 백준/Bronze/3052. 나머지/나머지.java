import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] number = new int[42];

        for (int i = 0; i < 42; i++) {
            number[i] = 0;
        }

        for (int i = 0; i < 10; i++) {
            int index = Integer.parseInt(br.readLine());
            int result = index % 42;
            number[result] = number[result] + 1;
        }

        int count = 0;
        for (int i = 0; i < 42; i++) {
            if (number[i] != 0) {
                count = count + 1;
            }
        }

        bw.write(String.valueOf(count));

        br.close();
        bw.close();
    }
}