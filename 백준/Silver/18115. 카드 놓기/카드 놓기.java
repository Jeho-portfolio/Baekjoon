import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String args[]) throws Exception   {
    	int N = Integer.parseInt(br.readLine());
    	
    	String str = br.readLine();
    	StringTokenizer st = new StringTokenizer(str, " ");
    	
    	LinkedList<Integer> skill = new LinkedList<>();
    	for (int i = 0; i < N; i++) {
    		skill.addFirst(Integer.parseInt(st.nextToken()));
    	}
    	
    	LinkedList<Integer> queue = new LinkedList<>();
    	
    	int index = 1;
    	while (!skill.isEmpty()) {
    		int sk = skill.poll();
    		if (sk == 1) {
    			queue.addFirst(index);
    			index = index + 1;
    		} else if (sk == 2) {
    			int tmp = queue.poll();
    			queue.addFirst(index);
    			index = index + 1;
    			queue.addFirst(tmp);
    		} else {
    			queue.addLast(index);
    			index = index + 1;
    		}
    	}
    	
    	while (!queue.isEmpty()) {
    		bw.write(queue.poll() + " ");
    	}
    	
        br.close();
        bw.close();
    }
}