import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] number = new int[M + 1];
		for (int i = 1; i <= M; i++) {
			number[i] = i;
		}

		int firstIndex = 2, nextIndex, lastIndex = (int) Math.sqrt(M);

		while (firstIndex <= lastIndex) {
			if (number[firstIndex] == 0) {
				firstIndex = firstIndex + 1;
			} else {
				nextIndex = firstIndex + 1;
				while (nextIndex <= M) {
					if (number[firstIndex] != 0 && number[nextIndex] != 0
							&& number[nextIndex] % number[firstIndex] == 0) {
						number[nextIndex] = 0;
					}
					nextIndex = nextIndex + 1;
				}
				firstIndex = firstIndex + 1;
			}
		}

		for (int i = N; i <= M; i++) {
			if (number[i] >= 2) {
				bw.write(String.valueOf(number[i]) + "\n");
			}
		}

		br.close();
		bw.close();
	}
}