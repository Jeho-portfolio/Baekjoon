import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception   {
    	String str = br.readLine();
    	StringTokenizer st = new StringTokenizer(str, " ");
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	int[] list = new int[N + 1];
    	
    	for (int i = 1; i <= N; i++) {
    		list[i] = 0;
    	}
    	
    	for (int index = 0; index < M; index++) {
    		str = br.readLine();
    		st = new StringTokenizer(str, " ");
    		int i = Integer.parseInt(st.nextToken());
    		int j = Integer.parseInt(st.nextToken());
    		int k = Integer.parseInt(st.nextToken());
    		
    		for (int target = i; target <= j; target++) {
    			list[target] = k;
    		}
    	}
    	
    	for (int index = 1; index <= N; index++) {
    		bw.write(list[index] + " ");
    	}

        br.close();
        bw.close();
    }
}