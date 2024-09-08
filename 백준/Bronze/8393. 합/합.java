import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception   {
    	int n = Integer.parseInt(br.readLine());
    	
    	long sum = 0;
    	for (int i = 1; i <= n; i++) {
    		sum = sum + i;
    	}
    	
    	bw.write(String.valueOf(sum));

        br.close();
        bw.close();
    }
}