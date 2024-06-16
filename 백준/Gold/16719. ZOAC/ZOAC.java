import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int length, count = 0;
	static ZOAC[] list;
	
    public static void main(String[] args) throws IOException {
    	String str = br.readLine();
    	length = str.length();
    	
    	list = new ZOAC[length];
    	
    	for (int i = 0; i < length; i++) {
    		list[i] = new ZOAC(str.charAt(i), 0, false);
    	}
    	
    	sequence(0, length);
    	
    	for (int i = 0; i < length; i++) {
    		for (int j = 0; j < length; j++) {
    			if (list[j].number <= i) {
    				bw.write(String.valueOf(list[j].str));
    			}
    		}
    		bw.write("\n");
    	}
    	
        br.close();
        bw.close();
    }
    
    static void sequence(int start, int end) {
    	if (start == end) {
    		return;
    	}
    	
    	int index = -1;
    	for (int i = start; i < end; i++) {
    		if (i == start) {
    			index = i;
    		} else {
    			if (!list[i].flag) {
    				if (list[i].str < list[index].str) {
        				index = i;
        			}
    			}
    		}    			    		
    	}
    	
    	list[index].number = count;
    	count = count + 1;
    	
    	sequence(index + 1, end);
    	sequence(start, index);
    }
}

class ZOAC {
	char str;
	int number;
	boolean flag;
	
	ZOAC(char s, int i, boolean f) {
		str = s;
		number = i;
		flag = f;
	}
}