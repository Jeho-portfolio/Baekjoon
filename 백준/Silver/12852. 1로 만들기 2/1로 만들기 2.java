import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] list = new int[1000001];
    static int[] pre = new int[1000001];

    public static void main(String args[]) throws Exception	{
        int N = Integer.parseInt(br.readLine());

        list[1] = 0;
        pre[1] = 0;

        int result = dp(N);

        bw.write(result + "\n");
        int tmp = N;
        while (tmp != 0) {
            bw.write(tmp + " ");
            tmp = pre[tmp];
        }

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
                pre[i] = i / 3;
            } else if (second <= first && second <= third) {
                list[i] = second;
                pre[i] = i / 2;
            } else {
                list[i] = third;
                pre[i] = i - 1;
            }
        }

        return list[k];
    }
}