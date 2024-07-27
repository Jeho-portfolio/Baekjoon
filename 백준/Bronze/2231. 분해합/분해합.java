import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());

        boolean flag = false;

        for (int i = 1; i <= 1000000; i++) {
            int result = i;
            int tmp = i;
            while (tmp > 0) {
                result = result + tmp % 10;
                tmp = tmp / 10;
            }

            if (result == N) {
                bw.write(String.valueOf(i));
                flag = true;
                break;
            }
        }

        if (!flag) {
            bw.write("0");
        }

        br.close();
        bw.close();
    }
}