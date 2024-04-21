import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Sentence[] sentence = new Sentence[N];
		
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			sentence[i] = new Sentence(str, 0);
		}
		
		StringBuilder sb = new StringBuilder();
		int a, t, g, c;
		for (int i = 0; i < M; i++) {
			a = 0;
			t = 0;
			g = 0;
			c = 0;
			for (int j = 0; j < N; j++) {
				char tmp = sentence[j].s.charAt(i);
				if (tmp == 'A') {
					a = a + 1;
				} else if (tmp == 'C') {
					c = c + 1;					
				} else if (tmp == 'G') {
					g = g + 1;
				} else {
					t = t + 1;
				}
			}
			
			if (a >= c && a >= g && a >= t) {
				sb.append('A');
			} else if (c > a && c >= g && c >= t) {
				sb.append('C');
			} else if (g > a && g > c && g >= t) {
				sb.append('G');
			} else {
				sb.append('T');
			}
			
			char ch = sb.charAt(i);
			for (int k = 0; k < N; k++) {
				char ctmp = sentence[k].s.charAt(i);
				if (ch != ctmp) {
					sentence[k].error = sentence[k].error + 1; 
				}
			}
		}
		
		int result = 0;
		for (int i = 0; i < N; i++) {
			result = result + sentence[i].error;
		}
		
		bw.write(String.valueOf(sb) + "\n");
		bw.write(String.valueOf(result));
		
		br.close();
		bw.close();
	}
}

class Sentence implements Comparable<Sentence>{
	String s;
	int error;
	Sentence(String st, int e) {
		s = st;
		error = e;
	}
	
	@Override
	public int compareTo(Sentence o) {
		if (this.error > o.error) {
			return 2;
		} else if (this.error == o.error) {
			return this.s.compareTo(o.s);
		} else {
			return -2;
		}
	}
}