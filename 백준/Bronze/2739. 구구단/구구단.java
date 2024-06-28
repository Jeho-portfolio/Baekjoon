import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
	
    public static void main(String[] args) throws IOException {
    	int N = Integer.parseInt(br.readLine());
    	
    	for (int i = 1; i <= 9; i++) {
    		bw.write(N + " * " + i + " = " + N * i + "\n");
    	}
    	
    	br.close();
        bw.close();
    }
}