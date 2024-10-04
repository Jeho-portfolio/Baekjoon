import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception   {
    	int N = Integer.parseInt(br.readLine());
    	
    	for (int i = 1; i < 2 * N; i++) {
    		for (int j = 1; j < 2 * N; j++) {
    			if (N > i) {
    				if (j > N - i && j < N + i) {
    					bw.write("*");
    				} else if (j <= N - i) {
    					bw.write(" ");
    				}
    			} else if (N == i) {
    				bw.write("*");
    			} else {
    				if (j > i - N && j < (2 * N) - (i - N)) {
    					bw.write("*");
    				} else if (j <= i - N) {
    					bw.write(" ");
    				}
    			}
    		}
    		if (i != (2 * N) - 1) {
    			bw.write("\n");	
    		}
    	}
    	
        br.close();
        bw.close();
    }
}