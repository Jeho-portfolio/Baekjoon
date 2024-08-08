import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String args[]) throws Exception	{		
		String first = br.readLine();
		String second = br.readLine();
		String third = br.readLine();
		
		int f = 0;
		if (!first.equals("Fizz") && !first.equals("Buzz") && !first.equals("FizzBuzz")) {
			f = Integer.parseInt(first);
			f = f + 3;
			if (f % 3 == 0 && f % 5 == 0) {
				bw.write("FizzBuzz");
			} else if (f % 3 == 0 && f % 5 != 0) {
				bw.write("Fizz");
			} else if (f % 3 != 0 && f % 5 == 0) {
				bw.write("Buzz");
			} else {
				bw.write(String.valueOf(f));
			}
		} else if (!second.equals("Fizz") && !second.equals("Buzz") && !second.equals("FizzBuzz")) {
			f = Integer.parseInt(second);
			f = f + 2;
			if (f % 3 == 0 && f % 5 == 0) {
				bw.write("FizzBuzz");
			} else if (f % 3 == 0 && f % 5 != 0) {
				bw.write("Fizz");
			} else if (f % 3 != 0 && f % 5 == 0) {
				bw.write("Buzz");
			} else {
				bw.write(String.valueOf(f));
			}
		} else if (!third.equals("Fizz") && !third.equals("Buzz") && !third.equals("FizzBuzz")) {
			f = Integer.parseInt(third);
			f = f + 1;
			if (f % 3 == 0 && f % 5 == 0) {
				bw.write("FizzBuzz");
			} else if (f % 3 == 0 && f % 5 != 0) {
				bw.write("Fizz");
			} else if (f % 3 != 0 && f % 5 == 0) {
				bw.write("Buzz");
			} else {
				bw.write(String.valueOf(f));
			}
		}
		
		br.close();
		bw.close();
	}
}