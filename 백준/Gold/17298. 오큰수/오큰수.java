import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);

		int[] number = new int[N];
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> s = new Stack<>();
		int index = 0;
		int[] result = new int[N];

		while (index < N) {
			if (s.size() == 0) {
				s.add(index);
				index = index + 1;
			} else {
				while (s.size() != 0 && number[s.peek()] < number[index]) {
					result[s.pop()] = number[index];
				}
				s.add(index);
				index = index + 1;
			}
		}

		while (s.size() > 0) {
			result[s.pop()] = -1;
		}

		for (int i = 0; i < N; i++) {
			bw.write(String.valueOf(result[i]) + " ");
		}

		br.close();
		bw.close();
	}
}
