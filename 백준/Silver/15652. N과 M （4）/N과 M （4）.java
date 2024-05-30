import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int N, M;
	static int[] arr = new int[8];
	static boolean[] visited = new boolean[8];
	
    public static void main(String[] args) throws IOException {
    	String str = br.readLine();
    	StringTokenizer st = new StringTokenizer(str);
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	sequence(0);
    	
        br.close();
        bw.close();
    }
    
    static void sequence(int k) throws IOException {
    	if (k == M) {
    		for (int i = 0; i < k; i++) {
    			bw.write(arr[i] + " ");
    		}
    		bw.write("\n");
    		return;
    	}
    	
    	for (int i = 1; i <= N; i++) {
    		if (k == 0) {
    			arr[k] = i;
        		visited[k] = true;
        		sequence(k + 1);
        		visited[k] = false;	
    		} else {
    			if (i >= arr[k - 1]) {
    				arr[k] = i;
            		visited[k] = true;
            		sequence(k + 1);
            		visited[k] = false;	
    			}
    		}    		
    	}
    }
}