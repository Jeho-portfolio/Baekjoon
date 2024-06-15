import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
    public static void main(String[] args) throws IOException {
    	int T = Integer.parseInt(br.readLine());
    	for (int i = 0; i < T; i++) {
    		String str = br.readLine();
    		StringTokenizer st = new StringTokenizer(str);
    		
    		int H = Integer.parseInt(st.nextToken());
    		int W = Integer.parseInt(st.nextToken());
    		int N = Integer.parseInt(st.nextToken());
    		
    		int height = N % H;
    		int length = N / H + 1;
			if (height == 0) {
    			height = H;
    			length = length - 1;
    		}    		
    		
			if (length < 10) {
				bw.write(height + "0" + length + "\n");	
			} else {
				bw.write(height + "" + length + "\n");
			}
    	}
    	
        br.close();
        bw.close();
    }
}