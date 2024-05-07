import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int count = 0;
		
		for (int i = 1; i <= N; i++) {
			if (i % 5 == 0) {
				count = count + 1;
				if (i % 25 == 0) {
					count = count + 1;	
				}
				if (i % 125 == 0) {
					count = count + 1;
				}
			}
		}
		
		bw.write(String.valueOf(count));
		
		br.close();
		bw.close();
	}
}