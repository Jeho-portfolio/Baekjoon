import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        String[] number = str.split(" ");

        int result = 0;
        for (int i = 0; i < 5; i++) {
            result = result + (int) Math.pow(Integer.parseInt(number[i]), 2);
        }

        bw.write(String.valueOf(result % 10));

        br.close();
        bw.close();
    }
}