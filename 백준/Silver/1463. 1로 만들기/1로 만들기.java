import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] list = new int[1000001];

    public static void main(String args[]) throws Exception	{
        int N = Integer.parseInt(br.readLine());

        list[1] = 0;

        int result = dp(N);

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }

    static int dp (int k) {
        for (int i = 2; i <= k; i++) {
            int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE, third;

            if (i % 3 == 0) {
                first = list[i / 3] + 1;
            }
            if (i % 2 == 0) {
                second = list[i / 2] + 1;
            }
            third = list[i - 1] + 1;

            if (first <= second && first <= third) {
                list[i] = first;
            } else if (second <= first && second <= third) {
                list[i] = second;
            } else {
                list[i] = third;
            }
            
        }

        return list[k];
    }
}