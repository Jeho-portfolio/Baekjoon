import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] number;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		number = new int[N];
		str = br.readLine();
		st = new StringTokenizer(str);
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(number);

		bw.write(String.valueOf(number[K - 1]));

		br.close();
		bw.close();
	}
}