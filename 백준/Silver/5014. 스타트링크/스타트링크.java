import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		Building[] building = new Building[F + 1];
		for (int i = 1; i <= F; i++) {
			building[i] = new Building(0, false);
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		building[S].flag = true;
		queue.add(S);
		while (!queue.isEmpty()) {
			int current = queue.poll();
			
			int up = current + U;
			int down = current - D;
			
			if (up >= 1 && up <= F && !building[up].flag) {
				building[up].flag = true;
				building[up].count = building[current].count + 1;
				queue.add(up);
			}
			if (down >= 1 && down <= F && !building[down].flag) {
				building[down].flag = true;
				building[down].count = building[current].count + 1;
				queue.add(down);
			}
		}
		
		
		if (S == G) {
			bw.write("0");
		} else if (building[G].flag) {
			bw.write(String.valueOf(building[G].count));
		} else {
			bw.write("use the stairs");
		}
		
		br.close();
		bw.close();
	}
}

class Building {
	int count;
	boolean flag;
	
	Building(int first, boolean second) {
		count = first;
		flag = second;
	}
}