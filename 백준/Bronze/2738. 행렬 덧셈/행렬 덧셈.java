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
    	
    	int[][] result = new int[N][M];
    	for (int i = 0; i < N; i++) {
    		str = br.readLine();
    		st = new StringTokenizer(str, " ");
    		for (int j = 0; j < M; j++) {
    			result[i][j] = Integer.parseInt(st.nextToken());    			
    		}
    	}
    	
    	for (int i = 0; i < N; i++) {
    		str = br.readLine();
    		st = new StringTokenizer(str, " ");
    		for (int j = 0; j < M; j++) {
    			result[i][j] = result[i][j] + Integer.parseInt(st.nextToken());    			
    		}
    	}
    	
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < M; j++) {
    			bw.write(result[i][j] + " ");    			
    		}
    		bw.write("\n");
    	}
    	
        br.close();
        bw.close();
    }
}