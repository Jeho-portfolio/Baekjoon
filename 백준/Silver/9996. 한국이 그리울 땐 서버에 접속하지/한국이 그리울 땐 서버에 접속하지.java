import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, "*");
		String first = st.nextToken();
		String last = st.nextToken();
		
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			tmp = tmp.replaceAll(first, "!");
			tmp = tmp.replaceAll(last, "@");
			int size = tmp.length();
			boolean flagFirst = false;
			boolean flagLast = false;
			int count = 0;
			for (int index = 0; index < size; index++) {
				if (tmp.charAt(index) == '!') {
					flagFirst = true;
					count = count + 1;
				}
				if (tmp.charAt(index) == '@') {
					flagLast = true;
				}
			}
			if (tmp.charAt(0) == '!' && (tmp.charAt(size - 1) == '!' || tmp.charAt(size - 1) == '@')) {
				if (first.equals(last)) {
					if (count >= 2) {
						bw.write("DA\n");
					} else {
						bw.write("NE\n");
					}
				} else {
					if (flagFirst && flagLast) {
						bw.write("DA\n");
					} else {
						bw.write("NE\n");
					}	
				}	
			} else {
				bw.write("NE\n");
			}
			
			
		}
		
		br.close();
		bw.close();
	}
}