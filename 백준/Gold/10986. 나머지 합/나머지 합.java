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

		long[] numberList = new long[N];
		long[] sumList = new long[N];
		long[] remainder = new long[M];
		long sum = 0;

		str = br.readLine();
		st = new StringTokenizer(str);
		for (int i = 0; i < N; i++) {
			numberList[i] = Integer.parseInt(st.nextToken());
			sum = sum + numberList[i];
			sumList[i] = sum;
			sumList[i] = sumList[i] % M;
		}

		long count = 0;

		for (int i = 0; i < N; i++) {
			if (sumList[i] == 0) {
				count = count + 1;
			}
			remainder[(int) sumList[i]] = remainder[(int) sumList[i]] + 1;
		}

		for (int i = 0; i < M; i++) {
			long c = (remainder[i] * (remainder[i] - 1)) / 2;
			count = count + c;
		}

		bw.write(String.valueOf(count));
		bw.flush();

		br.close();
		bw.close();
	}

}