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
		int P = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		str = br.readLine();

		int countA, countC, countG, countT, count = 0;

		String num = br.readLine();
		st = new StringTokenizer(num);

		countA = Integer.parseInt(st.nextToken());
		countC = Integer.parseInt(st.nextToken());
		countG = Integer.parseInt(st.nextToken());
		countT = Integer.parseInt(st.nextToken());

		int first = 0, last = first + (S - 1);
		int tmpA = 0, tmpC = 0, tmpG = 0, tmpT = 0;

		for (int i = 0; i < S; i++) {
			if (str.charAt(i) == 'A') {
				tmpA = tmpA + 1;
			} else if (str.charAt(i) == 'C') {
				tmpC = tmpC + 1;
			} else if (str.charAt(i) == 'G') {
				tmpG = tmpG + 1;
			} else if (str.charAt(i) == 'T') {
				tmpT = tmpT + 1;
			}
		}

		while (true) {
			if (tmpA >= countA && tmpC >= countC && tmpG >= countG && tmpT >= countT) {
				count = count + 1;
			}

			first = first + 1;
			last = last + 1;
			if (last == P) {
				break;
			}

			if (str.charAt(first - 1) == 'A') {
				tmpA = tmpA - 1;
			} else if (str.charAt(first - 1) == 'C') {
				tmpC = tmpC - 1;
			} else if (str.charAt(first - 1) == 'G') {
				tmpG = tmpG - 1;
			} else if (str.charAt(first - 1) == 'T') {
				tmpT = tmpT - 1;
			}

			if (str.charAt(last) == 'A') {
				tmpA = tmpA + 1;
			} else if (str.charAt(last) == 'C') {
				tmpC = tmpC + 1;
			} else if (str.charAt(last) == 'G') {
				tmpG = tmpG + 1;
			} else if (str.charAt(last) == 'T') {
				tmpT = tmpT + 1;
			}
		}

		bw.write(String.valueOf(count));
		bw.flush();

		br.close();
		bw.close();
	}

}