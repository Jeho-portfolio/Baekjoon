import java.io.*;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(br.readLine());
        String str = br.readLine();

        double[] list = new double[1000];
        double max = -1;
        double sum = 0;

        StringTokenizer st = new StringTokenizer(str);

        for (int i = 0; i < N; i++) {
            list[i] = Double.parseDouble(st.nextToken());
            if (max < list[i]) {
                max = list[i];
            }
        }

        for (int i = 0; i < N; i++) {
            list[i] = list[i] / max * 100;
            sum = sum + list[i];
        }

        bw.write(String.valueOf(sum / N));
        bw.flush();

        br.close();
        bw.close();
    }
}