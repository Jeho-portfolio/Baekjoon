import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
        	String str = br.readLine();
        	StringTokenizer st = new StringTokenizer(str);
        	long a = Long.parseLong(st.nextToken());
        	long b = Long.parseLong(st.nextToken());
        	bw.write(lcm(a, b) + "\n");
        }
        
        br.close();
        bw.close();
    }
    
    static long lcm(long first, long second) {
    	long result = 1;
    	long index = 2;
    	long max = Math.max(first, second);
    	
    	while (index <= max) {
    		if (first % index == 0 && second % index == 0) {
    			result = result * index;
    			first = first / index;
    			second = second / index;
    		} else {
    			index = index + 1;
    		}
    	}
    	
    	return result * first * second;
    }
}