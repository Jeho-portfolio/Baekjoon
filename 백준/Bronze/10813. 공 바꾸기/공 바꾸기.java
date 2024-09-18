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
    		list[i] = i;
    	}
    	
    	for (int i = 0; i < M; i++) {
    		str = br.readLine();
    		st = new StringTokenizer(str);
    		
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		
    		int tmp = list[a];
    		list[a] = list[b];
    		list[b] = tmp;
    	}
    	
    	for (int i = 1; i <= N; i++) {
    		bw.write(list[i] + " ");
    	}
    	
        br.close();
        bw.close();
    }
}