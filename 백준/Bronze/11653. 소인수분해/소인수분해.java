import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new LinkedList<>();
		
		int index = 2;
		if (N != 1) {
			while (index <= N) {
				if (N % index == 0) {
					queue.add(index);
					N = N / index;
				} else {
					index = index + 1;
				}
			}
		}
		
		while (!queue.isEmpty()) {
			bw.write(String.valueOf(queue.poll()) + "\n");
		}
		
		br.close();
		bw.close();
	}
}