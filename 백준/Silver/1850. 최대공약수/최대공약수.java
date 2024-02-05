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
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long tmp = euclidean(A, B);
		for (int i = 0; i < tmp; i++) {
			bw.write("1");
		}

		br.close();
		bw.close();
	}

	static long euclidean(long a, long b) {
		long max, other;
		if (a > b) {
			max = a;
			other = b;
		} else {
			max = b;
			other = a;
		}

		while (max % other != 0) {
			long tmp = max % other;
			max = other;
			other = tmp;
		}
		long gcd = other;
		return gcd;
	}
}
