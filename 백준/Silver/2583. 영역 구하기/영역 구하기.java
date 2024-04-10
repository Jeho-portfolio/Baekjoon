import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Field[][] field = new Field[M][N];
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				field[i][j] = new Field(0, 0);
			}
		}
		
		for (int i = 0; i < K; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Point end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			for (int j = M - end.y; j < M - start.y; j++) {
				for (int k = start.x; k < end.x; k++) {
					field[j][k].state = -1;
				}
			}
		}
		
		LinkedList<Integer> result = new LinkedList<>();
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (field[i][j].state == 0) {
					int max = 0;
					Queue<Point> queue = new LinkedList<>();
					field[i][j].state = 1;
					field[i][j].count = 1;
					queue.add(new Point(i, j));
					max = max + 1;
					
					
					while (!queue.isEmpty()) {
						Point current = queue.poll();
						if (field[current.x][current.y].count > max) {
							max = field[current.x][current.y].count;
						}
						
						for (int dir = 0; dir < 4; dir++) {
							int nx = current.x + dx[dir];
							int ny = current.y + dy[dir];
							
							if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
								if (field[nx][ny].state == 0) {
									field[nx][ny].state = 1;
									field[nx][ny].count = field[current.x][current.y].count + 1;
									queue.add(new Point(nx, ny));
									max = max + 1;
								}
							}
						}
					}
					result.add(max);
				}
			}
		}
		
		Collections.sort(result);
		ListIterator<Integer> iterator = result.listIterator();
		
		bw.write(String.valueOf(result.size()) + "\n");
		while (iterator.hasNext()) {
			bw.write(iterator.next() + " ");
		}
				
		br.close();
		bw.close();
	}
}

class Point {
	int x;
	int y;
	
	Point(int first, int second) {
		x = first;
		y = second;
	}
}

class Field {
	int state;
	int count;
	
	Field(int first, int second) {
		state = first;
		count = second;
	}
}