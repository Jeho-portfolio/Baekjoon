import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception   {
    	String str = br.readLine();
    	int l = str.length();
    	
    	Stack<Character> stack = new Stack<>();
    	
    	for (int i = 0; i < l / 2; i++) {
    		stack.add(str.charAt(i));
		}
    	
    	boolean flag = true;
    	if (l % 2 == 1) {
    		for (int i = (l / 2) + 1; i < l; i++) {
        		char tmp = str.charAt(i);
        		if (tmp != stack.pop()) {
        			bw.write("0");
        			flag = false;
        			break;
        		}
        	}	
    	} else {
    		for (int i = (l / 2); i < l; i++) {
        		char tmp = str.charAt(i);
        		if (tmp != stack.pop()) {
        			bw.write("0");
        			flag = false;
        			break;
        		}
        	}
    	}
    	
    	if (flag) {
    		bw.write("1");
    	}
    	
        br.close();
        bw.close();
    }
}