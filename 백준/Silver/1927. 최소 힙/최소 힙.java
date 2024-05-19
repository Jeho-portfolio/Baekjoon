import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
    public static void main(String[] args) throws IOException {
    	int N = Integer.parseInt(br.readLine());
    	
    	PriorityQueue<Integer> queue = new PriorityQueue<>();
    	
    	for (int i = 0; i < N; i++) {
    		int tmp = Integer.parseInt(br.readLine());
    		if (tmp == 0) {
    			if (!queue.isEmpty()) {
    				bw.write(queue.poll() + "\n");
    			} else {
    				bw.write("0\n");
    			}
    		} else {
    			queue.add(tmp);
    		}
    	}
    	
        br.close();
        bw.close();
    }
}