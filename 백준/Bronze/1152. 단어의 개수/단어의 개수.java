import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String str = br.readLine();

        String[] list = str.split(" ");

        int count = 0;
        for (int i = 0; i < list.length; i++) {
            if (!list[i].equals("")) {
                count = count + 1;
            }
        }

        bw.write(String.valueOf(count));

        br.close();
        bw.close();
    }
}