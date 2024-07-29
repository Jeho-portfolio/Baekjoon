import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int N, M;
	static int[] card;
	static boolean[] visited;
	static int[] arr = new int[3];
	static int result = 0;
	
	public static void main(String args[]) throws Exception	{
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		card = new int[N];
		visited = new boolean[N];
		
		str = br.readLine();
		st = new StringTokenizer(str);
		
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			visited[i] = false;
		}
		
		sequence(0);
		
		bw.write(String.valueOf(result));
		
		br.close();
		bw.close();
	}
	
	static void sequence(int k) {
		if (k == 3) {
			int tmp = 0;
			for (int i = 0; i < k; i++) {
				tmp = tmp + arr[i];
			}
			if (tmp > result && tmp <= M) {
				result = tmp;
			}
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				arr[k] = card[i];
				visited[i] = true;
				sequence(k + 1);
				visited[i] = false;
			}
		}
	}
}