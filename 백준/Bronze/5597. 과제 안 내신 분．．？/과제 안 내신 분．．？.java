import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception   {
    	boolean[] homework = new boolean[31];
    	
    	for (int i = 1; i <= 30; i++) {
    		homework[i] = false;
    	}
    	
    	for (int i = 0; i < 28; i++) {
    		int number = Integer.parseInt(br.readLine());
    		homework[number] = true;
    	}
    	
    	for (int i = 1; i <= 30; i++) {
    		if (!homework[i]) {
    			bw.write(i + "\n");
    		}
    	}
    	
        br.close();
        bw.close();
    }
}