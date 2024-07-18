import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        int i = Integer.parseInt(br.readLine());

        bw.write(str.charAt(i - 1));

        br.close();
        bw.close();
    }
}