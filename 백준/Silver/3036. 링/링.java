import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
    public static void main(String[] args) throws IOException {
    	
    	int N = Integer.parseInt(br.readLine());
    	String str = br.readLine();
    	String[] list = str.split(" ");
    	
    	int first = Integer.parseInt(list[0]);
    	for (int i = 1; i < list.length; i++) {
    		int f = first;
    		int tmp = Integer.parseInt(list[i]);
    		int t = tmp;
    		int result = 1;
    		int index = 2;
    		while (index <= first) {
    			if (t % index == 0 && f % index == 0) {
    				result = result * index;
    				f = f / index;
    				t = t / index;
    			} else {
    				index = index + 1;
    			}
    		}
    		
    		bw.write(first / result + "/" + tmp / result + "\n");
    	}
    	
        br.close();
        bw.close();
    }
}