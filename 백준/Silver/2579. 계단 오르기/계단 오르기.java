import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int T;
    static int[] stair;
    static int[][] score;

    public static void main(String args[]) throws Exception	{
        T = Integer.parseInt(br.readLine());
        stair = new int[T + 1];
        score = new int[T + 1][3];

        for (int i = 1; i <= T; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        if (T == 1) {
            bw.write(stair[1] + "\n");
        } else {
            score[1][1] = stair[1];
            score[1][2] = 0;
            score[2][1] = stair[2];
            score[2][2] = stair[1] + stair[2];

            climb(T);
            
            bw.write(String.valueOf(Math.max(score[T][1], score[T][2])));
        }

        br.close();
        bw.close();
    }

    static void climb(int k) {
        for (int i = 3; i <= T; i++) {
            score[i][1] = Math.max(score[i - 2][1], score[i - 2][2]) + stair[i];
            score[i][2] = score[i - 1][1] + stair[i];
        }
    }
}