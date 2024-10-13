import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception   {
    	int n = Integer.parseInt(br.readLine());
    	
    	int a = 1, b = 1;
    	boolean flag = true;
    	int target = 1;
    	int count = 0;
    	
    	for (int i = 1; i < n; i++) {
    		count = count + 1;
    		if (count == target) {
    			target = target + 1;
    			count = 0;
    			if (flag) {
    				b = b + 1;
    				flag = false;
    			} else {
    				a = a + 1;
    				flag = true;
    			}
    		} else {
    			if (flag) {
        			a = a - 1;
        			b = b + 1;
        		} else {
        			a = a + 1;
        			b = b - 1;
        		}	
    		}
    	}
    	
    	bw.write(a + "/" + b);
    	
        br.close();
        bw.close();
    }
}