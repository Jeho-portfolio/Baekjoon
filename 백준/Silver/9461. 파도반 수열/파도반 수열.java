import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception   {
    	long[] pn = new long[101];
    	
    	pn[1] = 1;
    	pn[2] = 1;
    	pn[3] = 1;
    	pn[4] = 2;
    	pn[5] = 2;
    	
    	for (int i = 6; i <= 100; i++) {
    		pn[i] = pn[i - 5] + pn[i - 1];
    	}
    	
    	int T = Integer.parseInt(br.readLine());
    	for (int i = 0; i < T; i++) {
    		int tmp = Integer.parseInt(br.readLine());
    		bw.write(pn[tmp] + "\n");
    	}
    	
        br.close();
        bw.close();
    }
}