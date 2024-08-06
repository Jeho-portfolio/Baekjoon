import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String args[]) throws Exception	{		
		int L = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		long r = 31;
		long M = 1234567891;
		
		long H = 0;
		for (int i = 0; i < L; i++) {
			char ch = str.charAt(i);
			long target = ch - 'a' + 1;
			long tmp = 1;
			for (int j = 0; j < i; j++) {
				tmp = tmp * r;
				tmp = tmp % M;
			}
			H = H + target * tmp;
			H = H % M;
		}
		
		bw.write(String.valueOf(H));
		
		br.close();
		bw.close();
	}
}