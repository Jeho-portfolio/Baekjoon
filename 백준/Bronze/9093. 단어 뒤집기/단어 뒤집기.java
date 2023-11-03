import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static String inverse(String str) {
		int l;
		String result = "";

		l = str.length();
		for (int i = l - 1; i >= 0; i--) {
			result += str.charAt(i);
		}

		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number, count;
		String str;
		String[] word;

		number = Integer.parseInt(br.readLine());

		for (int i = 0; i < number; i++) {
			str = br.readLine();
			word = str.split(" ");
			for (int j = 0; j < word.length; j++) {
				System.out.print(inverse(word[j]));
				System.out.print(" ");
			}
			System.out.println();
		}

		br.close();
	}

}
