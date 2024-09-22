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
    	
    	int[] number = new int[N + 1];
    	for (int i = 1; i <= N; i++) {
    		number[i] = i;
    	}
    	
    	for (int i = 0; i < M; i++) {
    		str = br.readLine();
    		st = new StringTokenizer(str, " ");
    		
    		int start = Integer.parseInt(st.nextToken());
    		int end = Integer.parseInt(st.nextToken());
    		
    		int[] tmp = new int[N + 1];
    		for (int index = start; index <= end; index++) {
    			tmp[index] = number[index];
    		}
    		
    		int target = end;
    		for (int index = start; index <= end; index++) {
    			number[index] = tmp[target];
    			target = target - 1;
    		}
    	}
    	
    	for (int i = 1; i <= N; i++) {
    		bw.write(number[i] + " ");
    	}
    	
        br.close();
        bw.close();
    }
}