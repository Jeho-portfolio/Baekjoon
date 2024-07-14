import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String args[]) throws Exception	{
		while (true) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			if (A == 0 && B == 0) {
				break;
			}
			
			bw.write((A + B) + "\n");
		}
		
		br.close();
		bw.close();
	}
}