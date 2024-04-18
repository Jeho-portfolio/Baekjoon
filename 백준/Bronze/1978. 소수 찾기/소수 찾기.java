import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] list = new int[N];
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
			if (list[i] == 1) {
				list[i] = 0;
			} else {
				for (int j = 2; j < list[i]; j++) {
					if (list[i] % j == 0) {
						list[i] = 0;
					}
				}
			}
			if (list[i] != 0) {
				count = count + 1;
			}
		}
		
		bw.write(String.valueOf(count));
		
		br.close();
		bw.close();
	}
}