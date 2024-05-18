import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
    public static void main(String[] args) throws IOException {
    	String first = br.readLine();
    	String[] f = first.split(" ");
    	String second = br.readLine();
    	String[] s = second.split(" ");
    	
    	int am = Integer.parseInt(f[1]);
    	int as = Integer.parseInt(f[0]);
    	int bm = Integer.parseInt(s[1]);
    	int bs = Integer.parseInt(s[0]);
    	
    	int max = Math.max(am, bm);
    	int result = 1;
    	int aa = am;
    	int bb = bm;
    	int index = 2;
    	while (index <= max) {
    		if (aa % index == 0 && bb % index == 0) {
    			result = result * index;
    			aa = aa / index;
    			bb = bb / index;
    		} else {
    			index = index + 1;
    		}
    	}
    	
    	result = result * aa * bb;
    	int an = (result / am);
    	int bn = (result / bm);
    	int sum = as * an + bs * bn;
    	
    	index = 2;
    	while (index <= result) {
    		if (sum % index == 0 && result % index == 0) {
    			sum = sum / index;
    			result = result / index;
    		} else {
    			index = index + 1;
    		}
    	}
    	
    	bw.write(sum + " " + result);
    	
        br.close();
        bw.close();
    }
}