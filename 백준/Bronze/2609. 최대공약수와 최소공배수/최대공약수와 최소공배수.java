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
		
		int index = 2;
		int result = 1;
		
		while (index <= A && index <= B) {
			if (A % index == 0 && B % index == 0) {
				result = result * index;
				A = A / index;
				B = B / index;
			} else {
				index = index + 1;
			}
		}
		
		bw.write(result + "\n" + result * A * B);
		
		br.close();
		bw.close();
	}
}