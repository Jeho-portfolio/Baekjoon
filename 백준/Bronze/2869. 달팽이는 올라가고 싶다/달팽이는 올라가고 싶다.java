import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
    	String str = br.readLine();
    	StringTokenizer st = new StringTokenizer(str);
    	int A = Integer.parseInt(st.nextToken());
    	int B = Integer.parseInt(st.nextToken());
    	int V = Integer.parseInt(st.nextToken());
    	
    	int result = 0;
    	
    	V = V - A;
    	int day = A - B;
    	if (V % day == 0) {
    		result = V / day;
    	} else {
    		result = V / day + 1;
    	}
    	
    	result = result + 1;
    	
    	bw.write(String.valueOf(result));
    	
        br.close();
        bw.close();
    }
}