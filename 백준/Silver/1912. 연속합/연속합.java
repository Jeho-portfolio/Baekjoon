import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception	{
        int n = Integer.parseInt(br.readLine());

        int[] number = new int[n];

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        int[] list = new int[n];

        list[0] = number[0];
        int max = list[0];

        for (int i = 1; i < n; i++) {
            list[i] = Math.max((list[i - 1] + number[i]), number[i]);
            if (list[i] > max) {
                max = list[i];
            }
        }

        bw.write(max + "\n");

        br.close();
        bw.close();
    }
}