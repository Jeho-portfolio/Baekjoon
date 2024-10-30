import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception	{
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        float W = Integer.parseInt(st.nextToken());
        float H = Integer.parseInt(st.nextToken());

        bw.write(W * H * (0.5) + "\n");

        br.close();
        bw.close();
    }
}