import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		Comparator<Integer> comparator = new Comparator<>() {
			@Override
			public int compare(Integer o1, Integer o2) {

				if (Math.abs(o1) == Math.abs(o2)) {
					return o1 < o2 ? -1 : 1;
				} else {
					return Math.abs(o1) - Math.abs(o2);
				}
			}
		};

		PriorityQueue<Integer> q = new PriorityQueue<>(comparator);

		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());

			if (input == 0) {
				if (q.isEmpty()) {
					bw.write(String.valueOf("0") + "\n");
				} else {
					bw.write(String.valueOf(q.poll()) + "\n");
				}
			} else {
				q.add(input);
			}
		}

		br.close();
		bw.close();
	}
}
