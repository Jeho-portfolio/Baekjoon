import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception   {
    	Character[][] list = new Character[5][15];
    	
    	for (int row = 0; row < 5; row++) {
    		String str = br.readLine();
    		int length = str.length();
    		
    		for (int index = 0; index < length; index++) {
    			list[row][index] = str.charAt(index);
    		}
    	}
    	
    	StringBuilder sb = new StringBuilder("");
    	
    	for (int i = 0; i < 15; i++) {
    		for (int j = 0; j < 5; j++) {
    			if (list[j][i] != null) {
    				sb.append(list[j][i]);
    			}
    		}
    	}
    	
    	bw.write(sb.toString());
    	
        br.close();
        bw.close();
    }
}