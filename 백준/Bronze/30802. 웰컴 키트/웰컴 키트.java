import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int[] people = new int[6];
        for (int i = 0; i < 6; i++) {
            people[i] = Integer.parseInt(st.nextToken());

        }
        str = br.readLine();
        st = new StringTokenizer(str);
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i = 0; i < 6; i++) {
            count = count + (people[i] / T);
            if (people[i] % T != 0) {
                count = count + 1;
            }
        }

        bw.write(count + "\n");
        bw.write((N / P) + " " + (N % P));

        br.close();
        bw.close();
    }
}