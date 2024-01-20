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
		int[] number = new int[N];
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(br.readLine());
		}

		int count = N - 1, tmp;
		boolean flag = false;
		while (count > 0) {
			for (int i = 0; i < count; i++) {
				if (number[i] > number[i + 1]) {
					tmp = number[i + 1];
					number[i + 1] = number[i];
					number[i] = tmp;
					flag = true;
				}
			}
			if (!flag) {
				break;
			}
			count = count - 1;
		}

		for (int i = 0; i < N; i++) {
			bw.write(String.valueOf(number[i]) + "\n");
		}

		br.close();
		bw.close();
	}
}
