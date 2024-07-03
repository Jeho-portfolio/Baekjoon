import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
    	String str = br.readLine();
    	StringTokenizer st = new StringTokenizer(str);
    	
    	boolean ascend = false, descend = false;
    	
    	int[] tab = new int[8];
    	
    	for (int i = 0; i < 8; i++) {
    		tab[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int index = 0;
    	
    	for (int i = 0; i < 8; i++) {
    		if (i == 0) {
    			index = tab[i];
    		} else {
    			if (tab[i] > index) {
    				ascend = true;
    			} else if (tab[i] < index) {
    				descend = true;
    			}
    			index = tab[i];
    		}
    	}
    	
    	if (ascend && descend) {
    		bw.write("mixed");
    	} else if (ascend) {
    		bw.write("ascending");
    	} else if (descend) {
    		bw.write("descending");
    	}
    	
        br.close();
        bw.close();
    }
}