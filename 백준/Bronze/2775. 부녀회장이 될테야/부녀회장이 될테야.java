import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception	{
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[k + 1][n + 1];
            for (int row = 0; row <= k; row++) {
                int sum = 0;
                for (int col = 1; col <= n; col++) {
                    if (row == 0) {
                        matrix[row][col] = col;
                    } else {
                        sum = sum + matrix[row - 1][col];
                        matrix[row][col] = sum;
                    }
                }
            }
            bw.write(matrix[k][n] + "\n");
        }

        br.close();
        bw.close();
    }
}