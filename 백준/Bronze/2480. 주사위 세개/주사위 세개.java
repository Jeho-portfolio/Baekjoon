import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception   {
    	String str = br.readLine();
    	StringTokenizer st = new StringTokenizer(str);
    	
    	int a = Integer.parseInt(st.nextToken());
    	int b = Integer.parseInt(st.nextToken());
    	int c = Integer.parseInt(st.nextToken());
    	
    	if (a == b && b == c) {
    		bw.write(String.valueOf(10000 + a * 1000));
    	} else if (a == b) {
    		bw.write(String.valueOf(1000 + a * 100));
    	} else if (b == c) {
    		bw.write(String.valueOf(1000 + b * 100));
    	} else if (a == c) {
    		bw.write(String.valueOf(1000 + c * 100));
    	} else {
    		int tmp = Math.max(a, b);
    		tmp = Math.max(c, tmp);
    		bw.write(String.valueOf(100 * tmp));
    	}

        br.close();
        bw.close();
    }
}