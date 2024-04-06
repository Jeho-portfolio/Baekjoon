import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Field[][] field = new Field[N][N];
		
		int nomal = 0, abnomal = 0;
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				char c = str.charAt(j);
				field[i][j] = new Field(c, false);
				nomal = nomal + 1;
				abnomal = abnomal + 1;
			}
		}
			
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		Queue<Point> queue = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!field[i][j].flag) {
					field[i][j].flag = true;
					char test = field[i][j].color;
					queue.add(new Point(i, j));
					
					while (!queue.isEmpty()) {
						Point current = queue.poll();
						
						for (int dir = 0; dir < 4; dir++) {
							int nx = current.x + dx[dir];
							int ny = current.y + dy[dir];
							
							if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
								if (!field[nx][ny].flag) {
									if (field[nx][ny].color == test) {
										field[nx][ny].flag = true;
										nomal = nomal - 1;
										queue.add(new Point(nx, ny));
									}									
								}
							}
						}
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				field[i][j].flag = false;
			}
		}
		
		queue = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!field[i][j].flag) {
					field[i][j].flag = true;
					char test = field[i][j].color;
					queue.add(new Point(i, j));
					
					while (!queue.isEmpty()) {
						Point current = queue.poll();
						
						for (int dir = 0; dir < 4; dir++) {
							int nx = current.x + dx[dir];
							int ny = current.y + dy[dir];
							
							if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
								if (!field[nx][ny].flag) {
									if (test == 'B') {
										if (field[nx][ny].color == 'B') {
											field[nx][ny].flag = true;
											abnomal = abnomal - 1;
											queue.add(new Point(nx, ny));	
										}										
									} else {
										if (field[nx][ny].color == 'R' || field[nx][ny].color == 'G') {
											field[nx][ny].flag = true;
											abnomal = abnomal - 1;
											queue.add(new Point(nx, ny));
										}
									}
								}
							}
						}
					}
				}
			}
		}
				
		bw.write(String.valueOf(nomal) + " " + String.valueOf(abnomal));
		
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
	char color;
	boolean flag;
	
	Field(char first, boolean second) {
		color = first;
		flag = second;
	}
}