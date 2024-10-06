import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception   {
    	int[] alphabet = new int[26];
    	
    	char[] list = new char[26];
    	for (int i = 0; i < 26; i++) {
    		list[i] = (char) ('A' + i);
    	}
    	
    	String str = br.readLine();
    	
    	int max = 0, maxIndex = 0;
    	boolean flag = true;
    	for (int i = 0; i < str.length(); i++) {
    		char tmp = Character.toUpperCase(str.charAt(i));
    		int index = tmp - 'A';
			alphabet[index] = alphabet[index] + 1;
			if (alphabet[index] > max) {
				max = alphabet[index];
				maxIndex = index;
				flag = true;
			} else if (alphabet[index] == max) {
				flag = false;
			}
    	}
    	
    	if (!flag) {
    		bw.write("?");
    	} else {
    		bw.write(String.valueOf(list[maxIndex]));
    	}
    	
        br.close();
        bw.close();
    }
}