import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception   {
    	String str = br.readLine();
    	StringTokenizer st = new StringTokenizer(str, " ");
    	
    	int[] user = new int[6];
    	for (int i = 0; i < 6; i++) {
    		user[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int[] chess = {1, 1, 2, 2, 2, 8};
    	
    	for (int i = 0; i < 6; i++) {
    		bw.write((chess[i] - user[i]) + " ");
    	}
    	
        br.close();
        bw.close();
    }
}