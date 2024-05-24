import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static char[][] video;
	
    public static void main(String[] args) throws IOException {
    	int N = Integer.parseInt(br.readLine());
    	video = new char[N][N];
    	
    	for (int i = 0; i < N; i++) {
    		String str = br.readLine();
    		for (int j = 0; j < N; j++) {
    			video[i][j] = str.charAt(j);
    		}
    	}
    	
    	count(0, 0, N);
    	
        br.close();
        bw.close();
    }
    
    static void count(int r, int c, int size) throws IOException{
    	boolean flag = true;
    	char target = video[r][c];
    	for (int i = r; i < r + size; i++) {
    		for (int j = c; j < c + size; j++) {
    			if (video[i][j] != target) {
    				flag = false;
    			}
    		}
    	}
    	
    	if (flag) {
    		bw.write(target);
    		return;
    	} else {
    		bw.write("(");
    		count(r, c, size / 2);
    		count(r, c + size / 2, size / 2);
    		count(r + size / 2, c, size / 2);
    		count(r + size / 2, c + size / 2, size / 2);
    		bw.write(")");
    	}
    }
}