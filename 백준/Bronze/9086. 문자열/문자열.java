import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception	{
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            int first = 0;
            int last = str.length() - 1;
            bw.write(str.charAt(first) + "" + str.charAt(last) + "\n");
        }

        br.close();
        bw.close();
    }
}