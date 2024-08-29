import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[] list = new int[12];	
	
	public static void main(String args[]) throws Exception	{
		int N = Integer.parseInt(br.readLine());
		
		int[][] rgb = new int[N + 1][3];
		int[][] sum = new int[N + 1][3];
		
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			rgb[i][0] = Integer.parseInt(st.nextToken());
			rgb[i][1] = Integer.parseInt(st.nextToken());
			rgb[i][2] = Integer.parseInt(st.nextToken());
		}
		
		sum[1][0] = rgb[1][0];
		sum[1][1] = rgb[1][1];
		sum[1][2] = rgb[1][2];
		
		for (int i = 2; i <= N; i++) {
			sum[i][0] = Math.min(sum[i - 1][1], sum[i - 1][2]) + rgb[i][0];
			sum[i][1] = Math.min(sum[i - 1][0], sum[i - 1][2]) + rgb[i][1];
			sum[i][2] = Math.min(sum[i - 1][0], sum[i - 1][1]) + rgb[i][2];
		}
		
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			if (sum[N][i] < result) {
				result = sum[N][i];
			}
		}
		
		bw.write(result + "\n");
		
		br.close();
		bw.close();
	}
}