import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception	{
        int N = Integer.parseInt(br.readLine());

        int[] number = new int[N];
        int[] list = new int[N];

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
            list[i] = number[i];
        }

        int max = list[0];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (number[j] < number[i]) {
                    list[i] = Math.max(list[i], list[j] + number[i]);
                    if (max < list[i]) {
                        max = list[i];
                    }
                }
            }
        }

        bw.write(String.valueOf(max));

        br.close();
        bw.close();
    }
}