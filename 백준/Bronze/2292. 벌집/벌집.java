import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
    	int N = Integer.parseInt(br.readLine());
    	
    	int index = 1;
    	int result = 1;
    	while (true) {
    		if (result >= N) {
    			break;
    		}
    		result = result + (6 * index);
    		index = index + 1;
    	}
    	
    	bw.write(String.valueOf(index));
    	
        br.close();
        bw.close();
    }
}