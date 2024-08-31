import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
	
	public static void main(String args[]) throws Exception	{
		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		
		if (x > 0 && y > 0) {
			bw.write("1");
		} else if (x < 0 && y > 0) {
			bw.write("2");
		} else if (x < 0 && y < 0) {
			bw.write("3");
		} else {
			bw.write("4");
		}
		
		br.close();
		bw.close();
	}
}