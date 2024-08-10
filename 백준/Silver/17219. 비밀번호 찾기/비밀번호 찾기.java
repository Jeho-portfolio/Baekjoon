import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String args[]) throws Exception	{		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			map.put(st.nextToken(), st.nextToken());
		}
		
		for (int i = 0; i < M; i++) {
			str = br.readLine();
			bw.write(map.get(str) + "\n");
		}
		
		br.close();
		bw.close();
	}
}