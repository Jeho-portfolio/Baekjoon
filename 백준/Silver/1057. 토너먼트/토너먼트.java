import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        int round = 1;
        
        int min = Math.min(a, b);
        int soo = Math.max(a, b);
        
        while (true) {
    		if ((min % 2 == 1) && (soo % 2 == 0)) {
    			if ((min + 1) == soo) {
    				bw.write(String.valueOf(round));
    				break;
    			}
    		}
    		
    		if (min % 2 == 1) {
    			min = (min + 1) / 2;
    		} else {
    			min = min / 2;
    		}
    		
    		if (soo % 2 == 1) {
    			soo = (soo + 1) / 2;
    		} else {
    			soo = soo / 2;
    		}
    		round = round + 1;
    	}

        br.close();
        bw.close();
    }
}
