import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
    public static void main(String[] args) throws IOException {
    	String str = br.readLine();
    	StringTokenizer st = new StringTokenizer(str);
    	
    	double A = Integer.parseInt(st.nextToken());
    	double B = Integer.parseInt(st.nextToken());
    	
    	double result = A / B;
    	
    	bw.write(String.valueOf(result));
    	
        br.close();
        bw.close();
    }
}