import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String args[]) throws Exception	{
        int max = 0;
        int x = 1;
        int y = 1;

        for (int i = 1; i <= 9; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            for (int j = 1; j <= 9; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp > max) {
                    max = tmp;
                    x = i;
                    y = j;
                }
            }
        }

        bw.write(max + "\n");
        bw.write(x + " " + y);

        br.close();
        bw.close();
    }
}