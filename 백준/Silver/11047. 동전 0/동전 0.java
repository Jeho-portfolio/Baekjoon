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
		int K = Integer.parseInt(st.nextToken());
		int[] coin = new int[N];

		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		int index = 0, count = 0;

		for (int i = N - 1; i >= 0; i--) {
			if (coin[i] <= K) {
				index = i;
				break;
			}
		}

		while (index >= 0) {
			int tmp = K / coin[index];
			count = count + tmp;
			K = K - (coin[index] * tmp);
			index = index - 1;
		}

		bw.write(String.valueOf(count));

		br.close();
		bw.close();
	}
}