import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int index = 2;
            int count = 0;
            while (N != 1) {
                if (N % index == 0) {
                    count = count + 1;
                    N = N / index;
                } else {
                    if (count != 0) {
                        bw.write(index + " " + count + "\n");
                    }
                    index = index + 1;
                    count = 0;
                }

                if (N == 1 && count != 0) {
                    bw.write(index + " " + count + "\n");
                }
            }
        }

        br.close();
        bw.close();
    }
}