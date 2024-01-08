import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int[] numberList = new int[N];
		for (int i = 0; i < N; i++) {
			numberList[i] = i;
		}

		int first = 0, last = 0;
		int count = 0;

		int sum = numberList[0];
		while (true) {
			if (sum < N) {
				last = last + 1;
				if (last >= N) {
					break;
				}
				sum = sum + numberList[last];
			} else if (sum > N) {
				sum = sum - numberList[first];
				first = first + 1;
			} else {
				count = count + 1;
				last = last + 1;
				if (last >= N) {
					break;
				}
				sum = sum + numberList[last];
			}
		}
		count = count + 1;

		bw.write(String.valueOf(count));
		bw.flush();

		br.close();
		bw.close();
	}

}