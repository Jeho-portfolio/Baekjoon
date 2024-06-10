import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int L, C;
	static String[] arr = new String[15];
	static boolean[] visited = new boolean[15];
	static String[] list;
	
    public static void main(String[] args) throws IOException {
    	
    	String str = br.readLine();
    	StringTokenizer st = new StringTokenizer(str);
    	L = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());
    	
    	
    	str = br.readLine();
     	st = new StringTokenizer(str);
     	
     	PriorityQueue<String> tmp = new PriorityQueue<>();
    	for (int i = 0; i < C; i++) {
    		tmp.add(st.nextToken());
    	}
    	
    	list = new String[C];
    	for (int i = 0; i < C; i++) {
    		list[i] = tmp.poll();
    	}
    	
    	sequence(0);
    	
        br.close();
        bw.close();
    }
    
    static void sequence(int x) throws IOException {
    	if (x == L) {
    		StringBuilder sb = new StringBuilder("");
    		int vowel = 0, consonant = 0;
    		for (int i = 0; i < L; i++) {
    			if (arr[i].equals("a") || arr[i].equals("e") || arr[i].equals("i") || arr[i].equals("o") || arr[i].equals("u")) {
    				vowel = vowel + 1;
    			} else {
    				consonant = consonant + 1; 
    			}
    			sb.append(arr[i]);
    		}
    		
    		if (vowel >= 1 && consonant >= 2) {
    			bw.write(sb.toString() + "\n");
    		}
    	}
    	
    	for (int i = 0; i < C; i++) {
    		if (!visited[i]) {
    			if (x == 0) {
    				arr[x] = list[i];
        			visited[i] = true;
        			sequence(x + 1);
        			visited[i] = false;	
    			} else {
    				int tmp = list[i].compareTo(arr[x - 1]);
    				if (tmp > 0) {
    					arr[x] = list[i];
            			visited[i] = true;
            			sequence(x + 1);
            			visited[i] = false;	
    				}
    			}
    		}
    	}
    }
}