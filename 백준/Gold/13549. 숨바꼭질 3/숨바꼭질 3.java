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
			bw.write("0");
		} else {
			State[] subin = new State[200001];
			for (int i = 0; i <= 200000; i++) {
				subin[i] = new State(0, false);
			}
			
			Queue<Integer> queue = new LinkedList<>();
			subin[N].flag = true;
			queue.add(N);	
			
			int[] dx = {2, -1, 1};
			while (!queue.isEmpty()) {
				int current = queue.poll();
				int nx = -1;
				
				for (int dir = 0; dir < 3; dir++) {
					if (dir != 0) {
						nx = current + dx[dir];
						if (nx >= 0 && nx <= 200000) {
							if (!subin[nx].flag) {
								subin[nx].flag = true;
								subin[nx].time = subin[current].time + 1;
								queue.add(nx);
							}
						}
					} else {
						nx = current * 2;
						if (nx >= 0 && nx <= 200000) {
							if (!subin[nx].flag) {
								subin[nx].flag = true;
								subin[nx].time = subin[current].time;
								queue.add(nx);
							}
						}
					}
				}
			}
			
			bw.write(String.valueOf(subin[K].time));
		}
		
		br.close();
		bw.close();
	}
}

class State {
	int time;
	boolean flag;
	
	State(int t, boolean f) {
		time = t;
		flag = f;
	}
}