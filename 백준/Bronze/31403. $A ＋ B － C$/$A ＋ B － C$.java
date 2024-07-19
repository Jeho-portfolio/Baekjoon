import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String args[]) throws Exception	{
		String A = br.readLine();
		int a = Integer.parseInt(A);
		String B = br.readLine();
		int b = Integer.parseInt(B);
		String C = br.readLine();
		int c = Integer.parseInt(C);
		
		int first = a + b - c;
		String ab = A + B;
		int second = Integer.parseInt(ab) - c;
		
		bw.write(first + "\n" + second);
		
		br.close();
		bw.close();
	}
}