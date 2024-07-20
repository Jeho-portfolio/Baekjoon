import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String args[]) throws Exception	{
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] chess = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				char ch = tmp.charAt(j);
				chess[i][j] = ch;
			}
		}
		
		int fR = Integer.MAX_VALUE;
		int sR = Integer.MAX_VALUE;
		
		int first = 0;
		int second = 0;
		
		for (int r = 0; r <= N - 8; r++) {
			for (int c = 0; c <= M - 8; c++) {
				first = 0;
				second = 0;
				
				for (int i = r; i < r + 8; i++) {
					for (int j = c; j < c + 8; j++) {
						char check = chess[i][j];
						if (i % 2 == 0 && j % 2 == 0) {
							if (check != 'B') {
								first = first + 1;
							}
						} else if (i % 2 == 0 && j % 2 == 1) {
							if (check != 'W') {
								first = first + 1;
							}
						} else if (i % 2 == 1 && j % 2 == 0) {
							if (check != 'W') {
								first = first + 1;
							}
						} else if (i % 2 == 1 && j % 2 == 1) {
							if (check != 'B') {
								first = first + 1;
							}
						}
						
						if (i % 2 == 0 && j % 2 == 0) {
							if (check != 'W') {
								second = second + 1;
							}
						} else if (i % 2 == 0 && j % 2 == 1) {
							if (check != 'B') {
								second = second + 1;
							}
						} else if (i % 2 == 1 && j % 2 == 0) {
							if (check != 'B') {
								second = second + 1;
							}
						} else if (i % 2 == 1 && j % 2 == 1) {
							if (check != 'W') {
								second = second + 1;
							}
						}
					}
				}
				
				if (first < fR) {
					fR = first;
				}
				if (second < sR) {
					sR = second;
				}
			}
		}

		if (fR < sR) {
			bw.write(String.valueOf(fR));
		} else {
			bw.write(String.valueOf(sR));
		}
		
		br.close();
		bw.close();
	}
}