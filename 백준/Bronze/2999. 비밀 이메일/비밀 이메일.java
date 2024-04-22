import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		int N = str.length();
		int R = 0, C = 0;
		for (int i = 1; i <= N; i++) {
			if (N % i == 0) {
				int tR = i;
				int tC = N / i;
				if (tR <= tC) {
					R = tR;
					C = tC;
				}
			}
		}
		
		Character[][] list = new Character[R][C];
		int count = 0;
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				list[j][i] = str.charAt(count);
				count = count + 1;
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				bw.write(list[i][j]);
			}
		}
		
		br.close();
		bw.close();
	}
}