import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String args[]) throws Exception	{
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			Queue<Paper> queue = new LinkedList<>();
			
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			str = br.readLine();
			st = new StringTokenizer(str);
			
			for (int index = 0; index < N; index++) {
				int tmp = Integer.parseInt(st.nextToken());
				
				queue.add(new Paper(index, tmp));
			}
			
			int count = 0;
			boolean flag = true;
			while (true) {
				flag = true;
				Iterator<Paper> iterator = queue.iterator();
				Paper target = iterator.next();
				while (iterator.hasNext()) {
					Paper temp = iterator.next();
					if (target.priority < temp.priority) {
						flag = false; 
						break;
					}
				}
				if (!flag) {
					queue.add(queue.poll());
				} else {
					Paper check = queue.poll();
					count = count + 1;
					if (check.index == M) {
						bw.write(count + "\n");
						break;
					}
				}
			}
		}
		
		br.close();
		bw.close();
	}
}

class Paper {
	int index;
	int priority;
	
	Paper(int i, int p) {
		index = i;
		priority = p;
	}
}