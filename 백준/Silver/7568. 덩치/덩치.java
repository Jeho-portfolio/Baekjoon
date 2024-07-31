import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String args[]) throws Exception	{
		int N = Integer.parseInt(br.readLine());
		
		Person[] p = new Person[N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			p[i] = new Person(w, h, 1);
		}
		
		for (int i = 0; i < N; i++) {
			Person index = p[i];
			for (int j = 0; j < N; j++) {
				if (i != j) {
					Person target = p[j];
					if (p[i].weight < p[j].weight && p[i].height < p[j].height) {
						p[i].rank = p[i].rank + 1; 
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			bw.write(p[i].rank + " ");
		}
		
		br.close();
		bw.close();
	}
}

class Person {
	int weight;
	int height;
	int rank;
	
	Person(int w, int h, int r) {
		weight = w;
		height = h;
		rank = r;
	}
}