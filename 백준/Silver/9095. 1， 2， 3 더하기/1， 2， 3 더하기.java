import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[] list = new int[12];	
	
	public static void main(String args[]) throws Exception	{
		int T = Integer.parseInt(br.readLine());
		
		list[1] = 1;
		list[2] = 2;
		list[3] = 4;
		
		for (int i = 4; i <= 11; i++) {
			list[i] = list[i - 1] + list[i - 2] + list[i - 3]; 
		}
		
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			
			bw.write(list[n] + "\n");
		}
		
		br.close();
		bw.close();
	}
}