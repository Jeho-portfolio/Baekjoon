import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String args[]) throws Exception	{
		String str = br.readLine();
		
		int[] alphabet = new int[26];
		for (int i = 0; i < 26; i++) {
			alphabet[i] = -1;
		}
		
		for (int i = 0; i < str.length(); i++) {
			char tmp = str.charAt(i);
			int index = tmp - 'a';
			if (alphabet[index] == -1) {
				alphabet[index] = i;	
			}
		}
		
		for (int i = 0; i < 26; i++) {
			bw.write(alphabet[i] + " ");
		}
		
		br.close();
		bw.close();
	}
}