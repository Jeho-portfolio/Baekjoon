import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] number = new int[3];
        int[] list = new int[10];

        for (int i = 0; i < 3; i++) {
            number[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < 10; i++) {
            list[i] = 0;
        }

        int result = number[0] * number[1] * number[2];
        while (result > 0) {
            int tmp = result % 10;
            list[tmp] = list[tmp] + 1;
            result = result / 10;
        }

        for (int i = 0; i < 10; i++) {
            bw.write(String.valueOf(list[i]) + "\n");
        }


        bw.close();
        br.close();
    }
    
}