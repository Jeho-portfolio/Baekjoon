import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] number = new int[N + 1];
		for (int i = 2; i <= N; i++) {
			number[i] = i;
		}
		
		int count = 0;
		int index = -1;
		boolean flag = false;
		
		while (true) {					
			for (int i = 2; i <= N; i++) {
				if (number[i] != -1) {
					index = i;
					break;
				}
			}
			
			for (int i = 2; i <= N; i++) {
				if (number[i] % index == 0) {
					number[i] = -1;
					count = count + 1;
					if (count == K) {
						bw.write(String.valueOf(i));
						flag = true;
						break;
					}
				}
			}
			if (flag) {
				break;
			}
		}
		
		br.close();
		bw.close();
	}
}