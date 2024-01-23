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
		int[] number = new int[N];

		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);

		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(number);

		int[] sum = new int[N];
		int tmp = 0, result = 0;
		for (int i = 0; i < N; i++) {
			tmp = tmp + number[i];
			sum[i] = tmp;
		}

		for (int i = 0; i < N; i++) {
			result = result + sum[i];
		}

		bw.write(String.valueOf(result));

		br.close();
		bw.close();
	}
}
