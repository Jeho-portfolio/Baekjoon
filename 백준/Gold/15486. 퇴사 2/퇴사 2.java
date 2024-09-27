import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception   {
    	int N = Integer.parseInt(br.readLine());
    	
    	int[] T = new int[N];
    	int[] P = new int[N];
    	
    	int[] maxProfit = new int[N + 1];
    	
    	for (int i = 0; i < N; i++) {
    		String str = br.readLine();
    		StringTokenizer st = new StringTokenizer(str, " ");
    		
    		T[i] = Integer.parseInt(st.nextToken());
    		P[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	for (int i = 0; i < N; i++) {
    		if (i + T[i] <= N) {
    			maxProfit[i + T[i]] = Math.max(maxProfit[i + T[i]], maxProfit[i] + P[i]);
    		}
    		maxProfit[i + 1] = Math.max(maxProfit[i], maxProfit[i + 1]); 
    	}
    	
    	bw.write(maxProfit[N] + "\n");
    	
        br.close();
        bw.close();
    }
}