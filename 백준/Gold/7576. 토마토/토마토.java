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
		
		Box[][] box = new Box[N][M];
		Queue<Pair> queue = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			for (int j = 0; j < M; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				box[i][j] = new Box(tmp, 0, false);
				if (tmp == 1) {
					queue.add(new Pair(i, j));
				}
			}
		}
		
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		
		int maxDay = 0;
		
		while (!queue.isEmpty()) {
			Pair current = queue.peek();
			queue.poll();
			box[current.x][current.y].flag = true;
			
			for (int dir = 0; dir < 4; dir++) {
				int nx = current.x + dx[dir];
				int ny = current.y + dy[dir];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && !box[nx][ny].flag && box[nx][ny].tomato == 0) {
					box[nx][ny].tomato = 1;
					box[nx][ny].day = box[current.x][current.y].day + 1;
					box[nx][ny].flag = true;
					queue.add(new Pair(nx, ny));
					if (box[nx][ny].day > maxDay) {
						maxDay = box[nx][ny].day;
					}	
				}				
			}
		}
		
		boolean check = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j].tomato == 0) {
					check = false;
				}
			}
		}
		
		if (check) {
			bw.write(String.valueOf(maxDay));	
		} else {
			bw.write("-1");
		}
		
				
		br.close();
		bw.close();
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

class Box {
	int tomato;
	int day;
	boolean flag;
	
	Box(int first, int second, boolean third) {
		tomato = first;
		day = second;
		flag = third;
	}
}



