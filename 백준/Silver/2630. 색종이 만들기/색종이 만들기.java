import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int[][] paper;
	
	static int blue = 0;
	static int white = 0;
	
    public static void main(String[] args) throws IOException {
    	int N = Integer.parseInt(br.readLine());
    	paper = new int[N][N];
    	
    	for (int i = 0; i < N; i++) {
    		String str = br.readLine();
    		StringTokenizer st = new StringTokenizer(str);
    		for (int j = 0; j < N; j++) {
    			paper[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	count(0, 0, N);
    	
    	bw.write(white + "\n" + blue);
    	
        br.close();
        bw.close();
    }
    
    static void count(int r, int c, int size) {
    	boolean flag = true;
    	int target = paper[r][c];
    	for (int i = r; i < r + size; i++) {
    		for (int j = c; j < c + size; j++) {
    			if (paper[i][j] != target) {
    				flag = false;
    			}
    		}
    	}
    	
    	if (flag) {
    		if (paper[r][c] == 1) {
    			blue = blue + 1;
    		} else {
    			white = white + 1;
    		}
    		return;
    	} else {
    		count(r, c, size / 2);
    		count(r, c + size / 2, size / 2);
    		count(r + size / 2, c, size / 2);
    		count(r + size / 2, c + size / 2, size / 2);
    	}
    }
}