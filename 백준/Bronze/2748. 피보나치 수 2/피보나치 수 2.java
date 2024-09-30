import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception	{
        long[] fibonacci = new long[91];
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for (int i = 2; i <= 90; i++) {
            fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1];
        }

        int N = Integer.parseInt(br.readLine());

        bw.write(fibonacci[N] + "\n");

        br.close();
        bw.close();
    }
}