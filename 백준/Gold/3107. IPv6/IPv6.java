import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		str = str.replace("::", ":mark:");
		String[] s = str.split(":");
		int count = 8 - s.length + 1;
		
		int check = 0;
		for (int i = 0; i < s.length; i++) {
			if (s[i].equals("mark")) {
				for (int j = 0; j < count; j++) {
					bw.write("0000");
					check = check + 1;
					if (check < 8) {
						bw.write(":");	
					}					
				}
			} else {
				if (s[i].length() == 4) {
					bw.write(s[i]);
				} else if (s[i].length() == 3) {
					bw.write("0" + s[i]);
				} else if (s[i].length() == 2) {
					bw.write("00" + s[i]);
				} else if (s[i].length() == 1) {
					bw.write("000" + s[i]);
				} else {
					bw.write("0000");
				}
				check = check + 1;
				if (check < 8) {
					bw.write(":");	
				}
			}
		}
		
		br.close();
		bw.close();
	}
}