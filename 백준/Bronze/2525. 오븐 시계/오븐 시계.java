import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
	
	public static void main(String args[]) throws Exception	{
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int cook = Integer.parseInt(br.readLine());
		
		m = m + cook;
		h = h + m / 60;
		m = m % 60;
		if (h >= 24) {
			h = h - 24;
		}
		
		bw.write(h + " " + m);
		
		br.close();
		bw.close();
	}
}