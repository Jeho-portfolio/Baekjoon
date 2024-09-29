import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception   {
    	String str = br.readLine();
    	StringTokenizer st = new StringTokenizer(str, " ");
    	
    	int A = Integer.parseInt(st.nextToken());
    	int tmp = 0;
    	for (int i = 0; i < 2; i++) {
    		tmp = (tmp * 10) + (A % 10);
    		A = A / 10;
    	}
    	A = (tmp * 10) + A;
    	
    	int B = Integer.parseInt(st.nextToken());
    	tmp = 0;
    	for (int i = 0; i < 2; i++) {
    		tmp = (tmp * 10) + (B % 10);
    		B = B / 10;
    	}
    	B = (tmp * 10) + B;
    	
    	if (A > B) {
    		bw.write(String.valueOf(A));
    	} else {
    		bw.write(String.valueOf(B));
    	}
    	
        br.close();
        bw.close();
    }
}