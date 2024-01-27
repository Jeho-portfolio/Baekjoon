import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		List[] list = new List[N];

		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			list[i] = new List(i, tmp);
		}

		Arrays.sort(list);

		int max = 0;
		int[] result = new int[N];

		for (int i = 0; i < N; i++) {
			result[i] = list[i].index - i + 1;
			if (result[i] > max) {
				max = result[i];
			}
		}

		bw.write(String.valueOf(max));

		br.close();
		bw.close();
	}
}

class List implements Comparable<List> {
	int index;
	int number;

	List(int first, int second) {
		index = first;
		number = second;
	}

	@Override
	public int compareTo(List o) {
		return this.number - o.number;
	}

}