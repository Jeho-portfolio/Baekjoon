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
		
		Maze[][] maze = new Maze[n][m]; 
		
		for (int i = 0; i < n; i++) {
			str = br.readLine();
			for (int j = 0; j < m; j++) {
				char c = str.charAt(j);
				String tmp = String.valueOf(c);
				maze[i][j] = new Maze(Integer.parseInt(tmp), -1);
			}
		}
		
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		
		
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(0,0));
		maze[0][0].length = maze[0][0].length + 1;
		
		while (!queue.isEmpty()) {
			Pair current = queue.peek();
			queue.poll();
			
			for (int dir = 0; dir < 4; dir++) {
				int nx = current.x + dx[dir];
				int ny = current.y + dy[dir];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
					continue;
				}
				if (maze[nx][ny].length >= 0 || maze[nx][ny].point != 1) {
					continue;
				}
				maze[nx][ny].length = maze[current.x][current.y].length + 1;
				queue.add(new Pair(nx, ny));
			}
		}
		
		bw.write(String.valueOf(maze[n - 1][m - 1].length + 1));		
		
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

class Maze {
	int point;
	int length;
	
	Maze(int first, int second) {
		point = first;
		length = second;
	}
}

