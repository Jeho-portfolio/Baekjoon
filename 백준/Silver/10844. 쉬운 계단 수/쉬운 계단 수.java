import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception   {
    	int N = Integer.parseInt(br.readLine());
    	
    	long[][] number = new long[N][10];
    	
    	number[0][0] = 0;
    	number[0][1] = 1;
    	number[0][2] = 1;
    	number[0][3] = 1;
    	number[0][4] = 1;
    	number[0][5] = 1;
    	number[0][6] = 1;
    	number[0][7] = 1;
    	number[0][8] = 1;
    	number[0][9] = 1;
    	
    	long sum = 0;
    	
    	if (N > 1) {
    		for (int i = 1; i < N; i++) {
    			for (int index = 0; index < 10; index++) {
    				long under = 0, up = 0;
    				if (index - 1 >= 0) {
    					under = number[i - 1][index - 1]; 
    				}
    				if (index + 1 <= 9) {
    					up = number[i - 1][index + 1]; 
    				}
    				number[i][index] = (under + up) % 1000000000;
    			}
    		}
    	}
    	
    	for (int i = 0; i < 10; i++) {
    		sum = (sum + number[N - 1][i]) % 1000000000;
    	}
    	
    	bw.write(sum + "\n");
    	
        br.close();
        bw.close();
    }
}