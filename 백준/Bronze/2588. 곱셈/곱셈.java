import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String args[]) throws Exception	{
		int first = Integer.parseInt(br.readLine());
		int second = Integer.parseInt(br.readLine());
		int tmp = second;
		
		bw.write(first * (second % 10) + "\n");
		second = second / 10;
		bw.write(first * (second % 10) + "\n");
		second = second / 10;
		bw.write(first * (second % 10) + "\n");
		bw.write(first * tmp + "\n");
		
		br.close();
		bw.close();
	}
}