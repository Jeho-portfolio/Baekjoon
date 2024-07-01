import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
    	int year = Integer.parseInt(br.readLine());
    	int result = -1;
    	
    	if (year % 4 == 0) {
    		if (year % 100 != 0) {
    			result = 1;
    		} else if (year % 400 == 0) {
    			result = 1;
    		} else {
    			result = 0;
    		}
    	} else {
    		result = 0;
    	}
    	
    	bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }
}