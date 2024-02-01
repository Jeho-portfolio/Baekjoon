import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		String[] minus = str.split("-");

		int size = minus.length;
		int[] number = new int[size];

		for (int i = 0; i < size; i++) {
			if (!minus[i].contains("+")) {
				number[i] = Integer.parseInt(minus[i]);
			} else {
				String[] tmp = minus[i].split("\\+");
				int sum = 0, length = tmp.length;
				for (int j = 0; j < length; j++) {
					sum = sum + Integer.parseInt(tmp[j]);
				}
				number[i] = sum;
			}
		}

		size = number.length;
		int result = 0;
		for (int i = 0; i < size; i++) {
			if (i == 0) {
				result = number[i];
			} else {
				result = result - number[i];
			}
		}

		bw.write(String.valueOf(result));

		br.close();
		bw.close();
	}
}
