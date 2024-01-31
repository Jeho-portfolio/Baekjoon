import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> negative = new PriorityQueue<>();
		Queue<Integer> one = new LinkedList<>();
		Queue<Integer> zero = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if (tmp > 1) {
				positive.add(tmp);
			} else if (tmp == 1) {
				one.add(tmp);
			} else if (tmp == 0) {
				zero.add(tmp);
			} else {
				negative.add(tmp);
			}
		}

		LinkedList<Integer> result = new LinkedList<>();

		while (positive.size() > 1) {
			int first = positive.poll();
			int second = positive.poll();
			result.add(first * second);
		}
		if (!positive.isEmpty()) {
			result.add(positive.poll());
		}

		while (negative.size() > 1) {
			int first = negative.poll();
			int second = negative.poll();
			result.add(first * second);
		}
		if (!negative.isEmpty()) {
			if (!zero.isEmpty()) {
				negative.poll();
			} else {
				result.add(negative.poll());
			}
		}

		result.add(one.size());

		int index = result.size();
		int sum = 0;
		for (int i = 0; i < index; i++) {
			sum = sum + result.poll();
		}

		bw.write(String.valueOf(sum));

		br.close();
		bw.close();
	}
}
