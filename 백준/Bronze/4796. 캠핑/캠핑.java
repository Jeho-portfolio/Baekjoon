import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int index = 1;
		while (true) {
			String str = br.readLine();
			if (str.equals("0 0 0")) {
				break;
			} else {
				StringTokenizer st = new StringTokenizer(str);
				int L = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				int V = Integer.parseInt(st.nextToken());
				int sum = 0;
				
				sum = sum + L * (V / P);
				int r = V % P;
				if (r > L) {
					sum = sum + L;
				} else {
					sum = sum + r;
				}
				bw.write("Case " + index + ": " + sum + "\n");
				index = index + 1;
			}
		}
		
		br.close();
		bw.close();
	}
}
