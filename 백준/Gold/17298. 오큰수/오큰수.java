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
		int[] result = new int[N];

		for (int i = 0; i < N; i++) {
			while (!s.empty() && number[s.peek()] < number[i]) {
				result[s.pop()] = number[i];
			}
			s.push(i);
		}

		while (!s.empty()) {
			result[s.pop()] = -1;
		}

		for (int i = 0; i < N; i++) {
			bw.write(String.valueOf(result[i]) + " ");
		}

		br.close();
		bw.close();
	}
}
