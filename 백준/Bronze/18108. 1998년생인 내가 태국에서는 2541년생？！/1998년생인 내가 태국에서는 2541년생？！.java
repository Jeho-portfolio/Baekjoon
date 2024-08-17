import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String args[]) throws Exception	{		
		int y = Integer.parseInt(br.readLine());
		
		bw.write(String.valueOf(y - 543));
		br.close();
		bw.close();
	}
}