import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String args[]) throws Exception	{
		PriorityQueue<Member> queue = new PriorityQueue<>(new Comparator<Member>() {
			@Override
			public int compare(Member o1, Member o2) {
				if (o1.age < o2.age) {
					return -1;	
				} else if (o1.age == o2.age) {
					if (o1.rank < o2.rank) {
						return 0;
					} else {
						return 1;
					}
				} else {
					return 2;
				}
			}
		});
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			queue.add(new Member(Integer.parseInt(st.nextToken()), i, st.nextToken()));
		}
		
		while (!queue.isEmpty()) {
			Member index = queue.poll();
			
			bw.write(index.age + " " + index.name + "\n");
		}
		
		br.close();
		bw.close();
	}
}

class Member {
	int age;
	int rank;
	String name;
	
	Member(int a, int r, String n) {
		age = a;
		rank = r;
		name = n;
	}
}