import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static char[][] star;
	
    public static void main(String[] args) throws IOException {
    	int N = Integer.parseInt(br.readLine());
    	
    	star = new char[N][(N * 2) - 1];    	
    	
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < (N * 2) - 1; j++) {
    			star[i][j] = ' ';
    		}
    	}
    	
    	draw(0, N - 1, N);
    	
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < (N * 2) - 1; j++) {
    			bw.write(star[i][j]);
    			}
    		bw.write("\n");
    	}
    	
        br.close();
        bw.close();
    }
    
    static void draw(int r, int c, int height) {
    	if (height == 3) {
    		star[r][c] = '*';
    		star[r + 1][c - 1] = '*';
    		star[r + 1][c + 1] = '*';
    		for (int i = 0; i < 5; i++) {
    			star[r + 2][c - 2 + i] = '*';
    		}
    		return;
    	} else {
    		height = height / 2;
    		draw(r, c, height);
    		draw(r + height, c - height, height);
    		draw(r + height, c + height, height);
    	}
    }
}