import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String args[]) throws Exception	{
		Stack<Character> stack = new Stack<>();
		
		while (true) {
			boolean flag = true;
			String str = br.readLine();
			
			int length = str.length();
			int index = 0, range = 0;
			
			if (length == 3) {
				index = 2;
				range = index - 1;
			} else {
				if (length % 2 == 0) {
					index = length / 2;
					range = index;
				} else {
					index = (length / 2) + 1;
					range = index - 1;
				}	
			}
			
			if (str.equals("0")) {
				break;
			} else {
				for (int i = 0; i < range; i++) {
					stack.add(str.charAt(i));
				}	
				
				while (!stack.isEmpty()) {
					if (stack.pop() != str.charAt(index)) {
						flag = false;
					}
					index = index + 1;
				}
				
				if (flag) {
					bw.write("yes\n");
				} else {
					bw.write("no\n");
				}
			}
		}
		
		br.close();
		bw.close();
	}
}