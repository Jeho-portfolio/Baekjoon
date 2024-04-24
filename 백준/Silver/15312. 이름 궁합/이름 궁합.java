import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String first = br.readLine();
		String second = br.readLine();
		int l = first.length();
		
		Queue<Character> ch = new LinkedList<>();
		int index = 0;
		for (int i = 0; i < l; i++) {
			ch.add(first.charAt(index));
			ch.add(second.charAt(index));
			index = index + 1;
		}
		
		LinkedList<Integer> queue = new LinkedList<>();
		while (!ch.isEmpty()) {
			char tmp = ch.poll();
			if (tmp == 'A') {
				queue.add(3);
			} else if (tmp == 'B') {
				queue.add(2);
			} else if (tmp == 'C') {
				queue.add(1);
			} else if (tmp == 'D') {
				queue.add(2);
			} else if (tmp == 'E') {
				queue.add(3);
			} else if (tmp == 'F') {
				queue.add(3);
			} else if (tmp == 'G') {
				queue.add(2);
			} else if (tmp == 'H') {
				queue.add(3);
			} else if (tmp == 'I') {
				queue.add(3);
			} else if (tmp == 'J') {
				queue.add(2);
			} else if (tmp == 'K') {
				queue.add(2);
			} else if (tmp == 'L') {
				queue.add(1);
			} else if (tmp == 'M') {
				queue.add(2);
			} else if (tmp == 'N') {
				queue.add(2);
			} else if (tmp == 'O') {
				queue.add(1);
			} else if (tmp == 'P') {
				queue.add(2);
			} else if (tmp == 'Q') {
				queue.add(2);
			} else if (tmp == 'R') {
				queue.add(2);
			} else if (tmp == 'S') {
				queue.add(1);
			} else if (tmp == 'T') {
				queue.add(2);
			} else if (tmp == 'U') {
				queue.add(1);
			} else if (tmp == 'V') {
				queue.add(1);
			} else if (tmp == 'W') {
				queue.add(1);
			} else if (tmp == 'X') {
				queue.add(2);
			} else if (tmp == 'Y') {
				queue.add(2);
			} else if (tmp == 'Z') {
				queue.add(1);
			}
		}
		
		int size = queue.size();
		while (size > 2) {
			size = size - 1;
			for (int i = 0; i < size; i++) {
				int f = queue.poll();
				int sum = (f + queue.peek()) % 10;
				queue.add(sum);
			}
			queue.poll();		
		}
		
		while (!queue.isEmpty()) {
			bw.write(String.valueOf(queue.poll()));
		}
		
		br.close();
		bw.close();
	}
}