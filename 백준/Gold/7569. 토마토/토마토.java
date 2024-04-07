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
		int H = Integer.parseInt(st.nextToken());
		
		Queue<Point> queue = new LinkedList<>();
		
		Box[][][] box = new Box[N][M][H];
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				str = br.readLine();
				st = new StringTokenizer(str);
				for (int j = 0; j < M; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					box[i][j][k] = new Box(tmp, false, 0);
					if (tmp == 1) {
						queue.add(new Point(i, j, k));
					}
				}
			}
		}
		
		int[] dx = {0, 1, 0, -1, 0, 0};
		int[] dy = {1, 0, -1, 0, 0, 0};
		int[] dz = {0, 0, 0, 0, 1, -1};
		
		while (!queue.isEmpty()) {
			Point current = queue.poll();
			
			for (int dir = 0; dir < 6; dir++) {
				int nx = current.x + dx[dir];
				int ny = current.y + dy[dir];
				int nz = current.z + dz[dir];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && nz >= 0 && nz < H) {
					if (box[nx][ny][nz].tomato == 0 && !box[nx][ny][nz].flag) {
						box[nx][ny][nz].flag = true;
						box[nx][ny][nz].tomato = 1;
						box[nx][ny][nz].count = box[current.x][current.y][current.z].count + 1;
						queue.add(new Point(nx, ny, nz));
					}
				}
			}
		}
		
		boolean check = true;
		int max = 0;
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (box[i][j][k].tomato == 0) {
						check = false;
					}
					if (box[i][j][k].count > max) {
						max = box[i][j][k].count;
					}
				}
			}
		}
		
		if (check) {
			bw.write(String.valueOf(max));
		} else {
			bw.write("-1");
		}
		
		br.close();
		bw.close();
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

class Box {
	int tomato;
	boolean flag;
	int count;
	
	Box(int first, boolean second, int third) {
		tomato = first;
		flag = second;
		count = third;
	}
}