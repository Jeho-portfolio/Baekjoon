import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] prison = new int[n + 1];
            for (int round = 1; round <= n; round++) {
                if (round == 1) {
                    for (int index = 1; index <= n; index++) {
                        prison[index] = 1;
                    }
                } else {
                    for (int index = round; index <= n; index = index + round) {
                        if (prison[index] == 0) {
                            prison[index] = 1;
                        } else {
                            prison[index] = 0;
                        }
                    }
                }
            }
            int count = 0;
            for (int index = 1; index <= n; index++) {
                if (prison[index] == 1) {
                    count = count + 1;
                }
            }
            bw.write(count + "\n");
        }

        br.close();
        bw.close();
    }
}