import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
	
    public static void main(String[] args) throws IOException {
    	int[] number = new int[10];
    	
    	int max = 0;
    	int index = 0;
    	
    	for (int i = 1; i <= 9; i++) {
    		number[i] = Integer.parseInt(br.readLine());
    		if (number[i] > max) {
    			max = number[i];
    			index = i;
    		}
    	}
    	
    	bw.write(max + "\n" + index);
    	
    	br.close();
        bw.close();
    }
}