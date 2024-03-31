import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Draw[][] d = new Draw[n][m]; 
		
		for (int i = 0; i < n; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			for (int j = 0; j < m; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				d[i][j] = new Draw(tmp, false);
			}
		}
		
		LinkedList<Integer> list = new LinkedList<>();
		
		Queue<Pair> queue = new LinkedList<>();
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		
		int count = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!d[i][j].flag) {
					d[i][j].flag = true;
					if (d[i][j].pixel == 1) {
						queue.add(new Pair(i,j));
						count = count + 1;
						
						while (!queue.isEmpty()) {
							Pair current = queue.peek();
							queue.poll();
							
							for (int dir = 0; dir < 4; dir++) {
								int nx = current.x + dx[dir];
								int ny = current.y + dy[dir];
								
								if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
									continue;
								}
								if (d[nx][ny].flag || d[nx][ny].pixel != 1) {
									continue;
								}
								d[nx][ny].flag = true;
								queue.add(new Pair(nx, ny));
								count = count + 1;
							}
						}
						list.add(count);
						count = 0;	
					}
				}
			}
		}
		
		Collections.sort(list);
		
		if (list.size() != 0) {
			bw.write(String.valueOf(list.size()) + "\n");
			bw.write(String.valueOf(list.peekLast()));	
		} else {
			bw.write("0\n0");
		}
		
		br.close();
		bw.close();
	}
}

class Draw {
	int pixel;
	boolean flag;
	
	Draw(int first, boolean second) {
		pixel = first;
		flag = second;
	}
}

class Pair {
	int x;
	int y;
	
	Pair(int first, int second) {
		x = first;
		y = second;
	}
}