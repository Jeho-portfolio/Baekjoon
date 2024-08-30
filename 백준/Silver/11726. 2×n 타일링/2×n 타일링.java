import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] block = new int[1001];

    public static void main(String args[]) throws Exception	{
        block[1] = 1;
        block[2] = 2;
        for (int i = 3; i <= 1000; i++) {
            block[i] = (block[i - 1] + block[i - 2]) % 10007;
        }

        int n = Integer.parseInt(br.readLine());

        bw.write(block[n] + "\n");

        br.close();
        bw.close();
    }
}