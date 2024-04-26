import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int number = lcm(M, N);
			int result = -1;
			
			Queue<Integer> queue = new LinkedList<>();
			
			for (int index = x; index <= number; index = index + M) {
				if (M == x) {
					x = 0;
				}
				if (index % M == x) {
					queue.add(index);
				}
			}
			
			while (!queue.isEmpty()) {
				if (N == y) {
					y = 0;
				}
				int tmp = queue.poll();
				if (tmp % N == y) {
					result = tmp;
					break;
				}
			}
			
			bw.write(String.valueOf(result) + "\n");
		}
		
		br.close();
		bw.close();
	}
	
	static int lcm(int first, int second) {
		int max = 0;
		if (first > second) {
			max = first;
		} else {
			max = second;
		}
		Queue<Integer> queue = new LinkedList<>();
		int index = 2;
		while (index < max) {
			if (first % index == 0 && second % index == 0) {
				first = first / index;
				second = second / index;
				queue.add(index);
			} else {
				index = index + 1;
			}			
		}
		
		int result = first * second;
		while (!queue.isEmpty()) {
			result = result * queue.poll();
		}		
		
		return result;
	}
}