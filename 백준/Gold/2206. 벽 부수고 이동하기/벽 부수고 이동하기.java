import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Field[][][] field = new Field[N][M][2];
		
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			for (int j = 0; j < M; j++) {
				char tmp = str.charAt(j);
				field[i][j][0] = new Field(Integer.parseInt(String.valueOf(tmp)), 1, false, 0);
				field[i][j][1] = new Field(Integer.parseInt(String.valueOf(tmp)), 1, false, 0);
			}
		}
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		Queue<Point> queue = new LinkedList<>();
		Point start = new Point(0, 0, 0);
		field[0][0][0].flag = true;
		queue.add(start);
		
		while (!queue.isEmpty()) {
			Point current = queue.poll();
			
			for (int dir = 0; dir < 4; dir++) {
				int nx = current.x + dx[dir];
				int ny = current.y + dy[dir];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (current.z == 0) {
						if (!field[nx][ny][current.z].flag) {
							if (field[nx][ny][current.z].state == 0) {
								field[nx][ny][current.z].flag = true;
								field[nx][ny][current.z].count = field[current.x][current.y][current.z].count + 1;
								field[nx][ny][current.z].block = field[current.x][current.y][current.z].block;
								queue.add(new Point(nx, ny, current.z));
							} else {
								if (field[current.x][current.y][current.z].block < 1) {
									field[nx][ny][1].flag = true;
									field[nx][ny][1].count = field[current.x][current.y][current.z].count + 1;
									field[nx][ny][1].block = field[current.x][current.y][current.z].block + 1;
									queue.add(new Point(nx, ny, 1));
								}
							}
						}
					} else {
						if (!field[nx][ny][current.z].flag) {
							if (field[nx][ny][current.z].state == 0) {
								field[nx][ny][current.z].flag = true;
								field[nx][ny][current.z].count = field[current.x][current.y][current.z].count + 1;
								field[nx][ny][current.z].block = field[current.x][current.y][current.z].block;
								queue.add(new Point(nx, ny, current.z));
							}
						}
					}
				}
			}
		}
		
		int result = -1;
		if (N != 1 && M != 1) {
			if (field[N - 1][M - 1][0].count == 1 && field[N - 1][M - 1][1].count == 1) {
				result = -1;
			} else if (field[N - 1][M - 1][0].count == 1 && field[N - 1][M - 1][1].count != 1) {
				result = field[N - 1][M - 1][1].count;
			} else if (field[N - 1][M - 1][0].count != 1 && field[N - 1][M - 1][1].count == 1) {
				result = field[N - 1][M - 1][0].count;
			} else {
				result = Math.min(field[N - 1][M - 1][0].count, field[N - 1][M - 1][1].count);
			}	
		} else {
			result = 1;
		}
				
		bw.write(String.valueOf(String.valueOf(result)));
		
		br.close();
		bw.close();
	}
}

class Field {
	int state;
	int count;
	boolean flag;
	int block;
	Field(int s, int c, boolean f, int b) {
		state = s;
		count = c;
		flag = f;
		block = b;
	}
}

class Point {
	int x;
	int y;
	int z;
	Point(int first, int second, int third) {
		x = first;
		y = second;
		z = third;
	}
}