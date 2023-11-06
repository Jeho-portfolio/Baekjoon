import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		int n, k, count = 0;

		str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		LinkedList<Integer> list = new LinkedList<>();
		int[] number = new int[n];

		for (int i = 1; i <= n; i++) {
			list.add(i);
		}

		for (int i = 0; i < n; i++) {
			count = count + k - 1;
			if (count >= list.size()) {
				count = count % list.size();
			}

			number[i] = list.get(count);
			list.remove(count);

		}

		for (int i = 0; i < n; i++) {
			if (n != 1) {
				if (i == 0) {
					System.out.printf("<%d, ", number[i]);
				} else if (i == n - 1) {
					System.out.printf("%d>", number[i]);
				} else {
					System.out.printf("%d, ", number[i]);
				}
			} else {
				System.out.printf("<%d>", number[i]);
			}

		}

		br.close();
	}

}
