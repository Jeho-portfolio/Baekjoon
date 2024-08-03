import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String args[]) throws Exception	{		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Point> queue = new PriorityQueue<>(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o1.x < o2.x) {
					return -2;	
				} else if (o1.x == o2.x) {
					if (o1.y <= o2.y) {
						return -1;
					} else {
						return 1;
					}
				} else {
					return 2;
				}
			}
			
		});
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			queue.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		
		while (!queue.isEmpty()) {
			Point tmp = queue.poll();
			
			bw.write(tmp.x + " " + tmp.y + "\n");
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