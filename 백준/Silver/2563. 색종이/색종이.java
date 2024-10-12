import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception   {
    	int[][] paper = new int[101][101];
    	
    	int count = 0;
    	
    	int n = Integer.parseInt(br.readLine());
    	for (int index = 0; index < n; index++) {
    		String str = br.readLine();
    		StringTokenizer st = new StringTokenizer(str , " ");
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		
    		for (int i = x; i < x + 10; i++) {
    			for (int j = y; j < y + 10; j++) {
    				if (paper[i][j] == 0) {
    					paper[i][j] = 1;
    					count = count + 1;
    				}
    			}
    		}
    	}
    	
    	bw.write(count + "\n");
    	
        br.close();
        bw.close();
    }
}