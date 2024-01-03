import java.io.*;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str1 = br.readLine();
        StringTokenizer st1 = new StringTokenizer(str1);

        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());

        int[] numberList = new int[N];
        int[] sumList = new int[N+1];
        int sum = 0;

        String str2 = br.readLine();
        StringTokenizer st2 = new StringTokenizer(str2);

        for (int i = 0; i < N; i++) {
            numberList[i] = Integer.parseInt(st2.nextToken());
            sumList[i] = sum;
            sum = sum + numberList[i];
        }
        sumList[N] = sum;

        for (int i = 0; i < M; i++) {
            String str3 = br.readLine();
            StringTokenizer st3 = new StringTokenizer(str3);
            int first = Integer.parseInt(st3.nextToken());
            int second = Integer.parseInt(st3.nextToken());
            bw.write(String.valueOf(sumList[second] - sumList[first - 1]));
            bw.write("\n");
            bw.flush();
        }

        br.close();
        bw.close();
    }
}