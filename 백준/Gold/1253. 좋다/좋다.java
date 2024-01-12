import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		ArrayList<Long> numberList = new ArrayList<>();

		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);

		for (int i = 0; i < N; i++) {
			numberList.add(Long.parseLong(st.nextToken()));
		}
		Collections.sort(numberList);

		int index = 0, first = 0, last = N - 2, count = 0;
		long number, sum;

		while (index < N) {
			number = numberList.get(index);
			numberList.remove(index);
			while (first < last) {
				sum = numberList.get(first) + numberList.get(last);
				if (sum < number) {
					first = first + 1;
				} else if (sum > number) {
					last = last - 1;
				} else {
					count = count + 1;
					break;
				}
			}
			first = 0;
			last = N - 2;
			numberList.add(index, number);
			index = index + 1;
		}

		bw.write(String.valueOf(count));
		bw.flush();

		br.close();
		bw.close();
	}

}