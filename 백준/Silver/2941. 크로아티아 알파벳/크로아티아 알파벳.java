import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		str = str.replaceAll("c=", "!");
		str = str.replaceAll("c-", "!");
		str = str.replaceAll("dz=", "!");
		str = str.replaceAll("d-", "!");
		str = str.replaceAll("lj", "!");
		str = str.replaceAll("nj", "!");
		str = str.replaceAll("s=", "!");
		str = str.replaceAll("z=", "!");
		
		int size = str.length();
		bw.write(String.valueOf(size));
		
		br.close();
		bw.close();
	}
}