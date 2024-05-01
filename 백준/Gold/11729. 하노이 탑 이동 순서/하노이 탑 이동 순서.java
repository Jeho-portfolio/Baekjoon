import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int result = (int) (Math.pow(2, N) - 1);
        bw.write(result + "\n");

        harnoi(1, 3, N - 1);

        br.close();
        bw.close();
    }

    static void harnoi(int f, int l, int n) throws IOException {
        if (n == 0) {
            bw.write(f + " " + l + "\n");
            return;
        }
        harnoi(f, 6 - f - l, n - 1);
        bw.write(f + " " + l + "\n");
        harnoi(6 - f - l, l, n - 1);
    }
}