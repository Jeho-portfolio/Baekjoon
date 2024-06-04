import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        int number[] = new int[1001];

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int index = 0;
        int target = 1;
        for (int i = 1; i <= 1000; i++) {
            number[i] = target;
            index = index + 1;
            if (index == target) {
                index = 0;
                target = target + 1;
            }
        }

        int sum = 0;
        for (int i = A; i <= B; i++) {
            sum = sum + number[i];
        }

        bw.write(String.valueOf(sum));

        br.close();
        bw.close();
    }
}