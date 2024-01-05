import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] numberList = new int[N+1][N+1];
        int[][] sumList = new int[N+1][N+1];
        int sum = 0;

        for (int i = 1; i <= N; i++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            for (int j = 1; j <= N; j++) {
                numberList[i][j] = Integer.parseInt(st.nextToken());
                sum = sum + numberList[i][j];
                sumList[i][j] = sum + sumList[i-1][j];
            }
            sum = 0;
        }

        for (int i = 0; i < M; i++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            int firstX = Integer.parseInt(st.nextToken());
            int firstY = Integer.parseInt(st.nextToken());
            int secondX = Integer.parseInt(st.nextToken());
            int secondY = Integer.parseInt(st.nextToken());
            int result = sumList[secondX][secondY] - sumList[firstX-1][secondY] - sumList[secondX][firstY-1] + sumList[firstX-1][firstY-1];
            bw.write(String.valueOf(result + "\n"));
            bw.flush();
        }

        bw.close();
        br.close();

    }
}