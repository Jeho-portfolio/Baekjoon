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
		
		if (N == K) {
			bw.write("0" + "\n" + N);
		} else {
			Subin[] subin = new Subin[200001];
			for (int i = 0; i < 200001; i++) {
				subin[i] = new Subin(false, 0, -1);
			}
			
			int[] dx = {2, 1, -1};
			
			Queue<Integer> queue = new LinkedList<>();
			subin[N].flag = true;
			queue.add(N);
			
			while (!queue.isEmpty()) {
				int current = queue.poll();
				
				for (int dir = 0; dir < 3; dir++) {
					int nx = -1;
					if (dir == 0) {
						nx = current * 2;
					} else {
						nx = current + dx[dir];
					}
					
					if (nx >= 0 && nx < 200001) {
						if (!subin[nx].flag) {
							subin[nx].flag = true;
							subin[nx].count = subin[current].count + 1;
							subin[nx].prev = current;
							queue.add(nx);
						}
					}
				}
			}
			
			bw.write(subin[K].count + "\n");
			Stack<Integer> stack = new Stack<>();
			stack.push(K);
			int target = subin[K].prev;
			while (target != -1) {
				stack.push(target);
				target = subin[target].prev;
			}
			
			while (!stack.isEmpty()) {
				bw.write(stack.pop() + " ");
			}
		}
		
		br.close();
		bw.close();
	}
}

class Subin {
	boolean flag;
	int count;
	int prev;
	
	Subin(boolean f, int c, int p) {
		flag = f;
		count = c;
		prev = p;
	}
}