import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		long[] numberList = new long[N];

		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		for (int i = 0; i < N; i++) {
			numberList[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(numberList);

		int first = 0, second = N - 1;
		long sum;
		long count = 0;
		while (true) {
			sum = numberList[first] + numberList[second];
			if (sum < M) {
				first = first + 1;
			} else if (sum > M) {
				second = second - 1;
			} else {
				count = count + 1;
				first = first + 1;
				second = second - 1;
			}
			if (first >= second) {
				break;
			}
		}

		bw.write(String.valueOf(count));
		bw.flush();

		br.close();
		bw.close();
	}

}