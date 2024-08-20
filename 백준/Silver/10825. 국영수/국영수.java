import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String args[]) throws Exception	{
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Student> queue = new PriorityQueue<>(new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
                if (s1.kor > s2.kor) {
                	return -4;
                } else if (s1.kor == s2.kor) {
                	if (s1.eng < s2.eng) {
                		return -3; 
                	} else if (s1.eng == s2.eng) {
                		if (s1.math > s2.math) {
                    		return -2; 
                    	} else if (s1.math == s2.math) {
                    		if (s1.name.compareTo(s2.name) < 0) {
                    			return -1;
                    		} else {
                    			return 1;
                    		}
                    	} else {
                    		return 2;
                    	}
                	} else {
                		return 3;
                	}
                } else {
                	return 4;
                }
            }
		});
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			Student tmp = new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			queue.add(tmp);
		}
		
		while (!queue.isEmpty()) {
			bw.write(queue.poll().name + "\n");
		}
		
		br.close();
		bw.close();
	}
}

class Student {
	String name;
	int kor;
	int eng;
	int math;
	
	Student(String n, int k, int e, int m) {
		name = n;
		kor = k;
		eng = e;
		math = m;
	}
}