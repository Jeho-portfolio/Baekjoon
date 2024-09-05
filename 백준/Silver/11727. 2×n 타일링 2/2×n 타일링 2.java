import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] tile = new int[1001];

    public static void main(String args[]) throws Exception	{
        tile[1] = 1;
        tile[2] = 3;

        for (int i = 3; i <= 1000; i++) {
            tile[i] = (tile[i - 1] + tile[i - 2] + tile[i - 2]) % 10007;
        }

        int n = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(tile[n]));

        br.close();
        bw.close();
    }
}