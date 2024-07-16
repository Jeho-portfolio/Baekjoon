import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String args[]) throws Exception	{
		String str = br.readLine();
		char ch = str.charAt(0);
		
		int result = 0;
		
		if (ch >= '0' && ch <= '9') {
			result = 48;
			result = result + (ch - '0');
		} else if (ch >= 'A' && ch <= 'Z') {
			result = 65;
			result = result + (ch - 'A');
		} else if (ch >= 'a' && ch <= 'z') {
			result = 97;
			result = result + (ch - 'a');
		}
		
		bw.write(String.valueOf(result));
		
		br.close();
		bw.close();
	}
}