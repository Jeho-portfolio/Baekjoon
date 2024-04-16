import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		int length = str.length();
		
		LinkedList<Character> list = new LinkedList<>();
		
		for (int i = 0; i < length; i++) {
			list.add(str.charAt(i));
		}		
		
		boolean c = false, j = false, cTmp = false, jTmp = false;
		
		int index = 0; 
		while (index < list.size()) {
			char tmp = list.get(index);
			if (index == 0) {
				if (tmp == '_' || (tmp >= 'A' && tmp <= 'Z')) {
					cTmp = true;
					break;
				}
			}
			
			if (cTmp) {
				if (tmp != '_') {
					char change = Character.toUpperCase(tmp);
					list.set(index, change);
					cTmp = false;	
				} else {
					break;
				}				
			}
			
			if (tmp == '_') {
				cTmp = true;
				if (!c) {
					c = true;
				}
				list.remove(index);
				index = index - 1;
			} else if (tmp >= 'A' && tmp <= 'Z') {
				char change = Character.toLowerCase(tmp);
				list.add(index, '_');
				index = index + 1;
				list.add(index, change);
				index = index + 1;
				list.remove(index);
				index = index - 1;
				if (!j) {
					j = true;
				}
			}
			
			index = index + 1;
		}
		
		if ((c && j) || cTmp) {
			bw.write("Error!");
		} else {
			while (!list.isEmpty()) {
				bw.write(String.valueOf(list.poll()));	
			}			
		}
				
		br.close();
		bw.close();
	}
}