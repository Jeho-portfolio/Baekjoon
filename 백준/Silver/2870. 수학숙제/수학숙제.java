import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<String> queue = new PriorityQueue<>();
		StringBuilder sb;
		String s;
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			int length = str.length();
			
			sb = new StringBuilder();
			for (int index = 0; index < length; index++) {
				char tmp = str.charAt(index);
				if (tmp >= '0' && tmp <= '9') {
					sb.append(tmp);
				} else {
					s = String.valueOf(sb);
					int tmpL = s.length();
					if (tmpL != 0) {
						StringBuilder sbTmp = new StringBuilder();
						for (int j = 0; j < (100 - tmpL); j++) {
							sbTmp.append("0");
						}
						sbTmp.append(s);
						queue.add(String.valueOf(sbTmp));	
					}
					sb = new StringBuilder();
				}
			}
			
			s = String.valueOf(sb);
			int tmpL = s.length();
			if (tmpL != 0) {
				StringBuilder sbTmp = new StringBuilder();
				for (int j = 0; j < (100 - tmpL); j++) {
					sbTmp.append("0");
				}
				sbTmp.append(s);
				queue.add(String.valueOf(sbTmp));	
			}
		}
		
		while (!queue.isEmpty()) {
			String st = queue.poll();
			int c = 0;
			for (int i = 0; i < st.length(); i++) {
				if (st.charAt(i) != '0') {
					c = i;
					break;
				}
			}
			
			if (c == 0) {
				bw.write("0\n");
			} else {
				bw.write(st.substring(c) + "\n");	
			}			
		}
		
		br.close();
		bw.close();
	}
}