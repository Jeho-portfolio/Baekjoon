import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String args[]) throws Exception	{
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		bw.write((A + B) % C + "\n");
		bw.write(((A % C) + (B % C)) % C + "\n");
		bw.write((A * B) % C + "\n");
		bw.write(((A % C) * (B % C)) % C + "\n");
		
		br.close();
		bw.close();
	}
}