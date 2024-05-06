import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int max = 123456;
		int[] number = new int[(2 * max) + 1];
		
		for (int i = 2; i <= 2 * max; i++) {
			number[i] = i;
		}
		
		int index = 2;
		int limit = (int) Math.sqrt(2 * max);
		while (index <= limit) {
			while (number[index] == 0) {
				index = index + 1;
			}
			
			for (int i = index + 1; i <= 2 * max; i++) {
				if (number[i] % index == 0) {
					number[i] = 0;
				}
			}
			
			index = index + 1;
		}
		
		while(true) {
			String str = br.readLine();
			if (str.equals("0")) {
				break;
			} else {
				int count = 0;
				int n = Integer.parseInt(str);
				for (int i = n + 1; i <= 2 * n; i++) {
					if (number[i] != 0) {
						count = count + 1;
					}
				}
				bw.write(count + "\n");
			}
		}
		
		br.close();
		bw.close();
	}
}