import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int index = 1;
        int e = 1;
    	int s = 1;
    	int m = 1;
    	
        while (true) {
        	if (e == E && s == S && m == M) {
        		bw.write(String.valueOf(index));
        		break;
        	}
        	index = index + 1;
        	e = e + 1;
        	if (e >= 16) {
        		e = 1;
        	}
        	s = s + 1;
        	if (s >= 29) {
        		s = 1;
        	}
        	m = m + 1;
        	if (m >= 20) {
        		m = 1;
        	}
        }
        
        br.close();
        bw.close();
    }
}