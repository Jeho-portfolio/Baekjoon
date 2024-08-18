import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String args[]) throws Exception	{
		Queue<Long> queue = new LinkedList<>();
		LinkedList<Long> list = new LinkedList<>();
		
		while (true) {
			String str = br.readLine();
			if (str == null) {
				break;
			} else {
				StringTokenizer st = new StringTokenizer(str);
				while (st.hasMoreTokens()) {
					queue.add(Long.parseLong(st.nextToken()));
				}
			}
		}
		
		queue.poll();
		
		while (!queue.isEmpty()) {
			long tmp = queue.poll();
			long number = 0;
			while (tmp > 0) {
				long t = tmp % 10;
				if (tmp != 0) {
					number = number * 10 + t;
				}
				tmp = tmp / 10;
			}
			list.add(number);
		}
		
		Collections.sort(list);
		
		
		while (!list.isEmpty()) {
			bw.write(list.poll() + "\n");
		}
		
		br.close();
		bw.close();
	}
}