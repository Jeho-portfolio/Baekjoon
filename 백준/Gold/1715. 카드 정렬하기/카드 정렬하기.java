import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> number = new PriorityQueue<>();
		PriorityQueue<Integer> result = new PriorityQueue<>();

		int tmp;
		for (int i = 0; i < N; i++) {
			tmp = Integer.parseInt(br.readLine());
			number.add(tmp);
		}

		while (number.size() > 1) {
			int first = number.poll();
			int second = number.poll();
			tmp = first + second;
			number.add(tmp);
			result.add(tmp);
		}

		int sum = 0;
		while (result.size() > 0) {
			sum = sum + result.poll();

		}

		bw.write(String.valueOf(sum));

		br.close();
		bw.close();
	}
}