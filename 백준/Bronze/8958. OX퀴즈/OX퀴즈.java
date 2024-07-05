import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String args[]) throws Exception	{
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			String str = br.readLine();
			int l = str.length();
			
			int result = 0;
			
			int count = 0;
			for (int j = 0; j < l; j++) {
				if (str.charAt(j) == 'O') {
					count = count + 1;
				} else {
					count = 0;
				}
				
				result = result + count;
			}
			
			bw.write(result + "\n");
		}
		
		br.close();
		bw.close();	
	}
}