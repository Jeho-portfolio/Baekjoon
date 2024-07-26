import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String args[]) throws Exception	{
		int N = Integer.parseInt(br.readLine());
		
		int[] number = new int[N];
		int[] count = new int[8001];
		
		for (int i = 0; i < 8001; i++) {
			count[i] = 0;
		}
		
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			number[i] = tmp;
			count[tmp + 4000] = count[tmp + 4000] + 1;
		}
		
		Arrays.sort(number);
		
		double max = 0;
		for (int i = 0; i < N; i++) {
			max = max + number[i];
		}
		
		max = Math.round(max / N);
		
		bw.write((int) max + "\n");
		
		bw.write(number[N / 2] + "\n");
		
		int c = 0;
		for (int i = 0; i < 8001; i++) {
			if (count[i] > c) {
				c = count[i];
			}
		}
		
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		for (int i = 0; i < 8001; i++) {
			if (count[i] == c) {
				queue.add(i - 4000);
			}
		}
		
		if (queue.size() == 1) {
			bw.write(queue.poll() + "\n");
		} else {
			queue.poll();
			bw.write(queue.poll() + "\n");
		}
		
		bw.write(number[N - 1] - number[0] + "\n");
		
		br.close();
		bw.close();
	}
}