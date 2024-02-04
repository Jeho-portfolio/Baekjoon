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

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			euclidean(A, B);
		}

		br.close();
		bw.close();
	}

	static void euclidean(int a, int b) {
		int max, other;
		if (a > b) {
			max = a;
			other = b;
		} else {
			max = b;
			other = a;
		}

		while (max % other != 0) {
			int tmp = max % other;
			max = other;
			other = tmp;
		}
		int gcd = other;
		System.out.println(a * b / gcd);

	}
}
