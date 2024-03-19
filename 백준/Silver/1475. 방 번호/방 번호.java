import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int number = Integer.parseInt(br.readLine());
        int[] list = new int[9];

        for (int i = 0; i < 9; i++) {
            list[i] = 0;
        }

        while (number > 0) {
            int tmp = number % 10;
            number = number / 10;
            if (tmp == 9) {
                list[6] = list[6] + 1;
            } else {
                list[tmp] = list[tmp] + 1;
            }
        }

        int count = 0;

        list[6] = Math.round((float)list[6] / 2);

        for (int i = 0; i < 9; i++) {
            if (count < list[i]) {
                count = list[i];
            }
        }

        bw.write(String.valueOf(count));

        bw.close();
        br.close();
    }
    
}