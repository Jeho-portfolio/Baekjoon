import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int k;
	static int[] arr = new int[12];
	static boolean[] visited = new boolean[12];
	static int[] number;
	
    public static void main(String[] args) throws IOException {
    	
    	while (true) {
    		String str = br.readLine();
    		if (str.equals("0")) {
    			break;
    		} else {
    			StringTokenizer st = new StringTokenizer(str);
    			k = Integer.parseInt(st.nextToken());
    			number = new int[k];
    			for (int i = 0; i < k; i++) {
    				number[i] = Integer.parseInt(st.nextToken());
    			}
    			sequence(0);
    			bw.write("\n");
    		}        		
    	}
    	
        br.close();
        bw.close();
    }
    
    static void sequence(int x) throws IOException {
    	if (x == 6) {
    		for (int i = 0; i < 6; i++) {
    			bw.write(arr[i] + " ");
    		}
    		bw.write("\n");
    		return;
    	}
    	
    	for (int i = 0; i < k; i++) {
    		if (!visited[i]) {
    			if (x == 0) {
    				arr[x] = number[i];
        			visited[i] = true;
        			sequence(x + 1);
        			visited[i] = false;	
    			} else {
    				if (number[i] > arr[x - 1]) {
    					arr[x] = number[i];
            			visited[i] = true;
            			sequence(x + 1);
            			visited[i] = false;
    				}
    			}
    		}
    	}
    }
}