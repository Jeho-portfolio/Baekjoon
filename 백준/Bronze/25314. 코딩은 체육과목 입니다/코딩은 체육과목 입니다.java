import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String args[]) throws Exception	{
        int N = Integer.parseInt(br.readLine());

        int loop = N / 4;
        
        for (int i = 0; i < loop; i++) {
            bw.write("long ");
        }
        bw.write("int");

        br.close();
        bw.close();
    }
}