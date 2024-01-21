import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String number = br.readLine();
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < number.length(); i++) {
			list.add(Integer.parseInt(String.valueOf(number.charAt(i))));
		}

		int index = 0, maxIndex = -1, maxNumber = -1, tmp;
		boolean flag = false;
		while (index < number.length()) {
			for (int i = index; i < number.length(); i++) {
				if (list.get(i) > maxNumber) {
					maxIndex = i;
					maxNumber = list.get(i);
					flag = true;
				}
			}
			if (flag) {
				tmp = list.get(index);
				list.set(index, maxNumber);
				list.set(maxIndex, tmp);
				flag = false;
			}
			index = index + 1;
			maxIndex = -1;
			maxNumber = -1;
		}

		for (int i = 0; i < list.size(); i++) {
			bw.write(String.valueOf(list.get(i)));
		}

		br.close();
		bw.close();
	}
}
