import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception	{
        int N = Integer.parseInt(br.readLine());

        Integer[] list = new Integer[N];

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(list, Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            bw.write(list[i] + "\n");
        }

        br.close();
        bw.close();
    }
}