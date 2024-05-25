import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static char[][] star;
	
    public static void main(String[] args) throws IOException {
    	int N = Integer.parseInt(br.readLine());
    	
    	star = new char[N][N];
    	
    	draw(0, 0, N, '*');
    	
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < N; j++) {
    			bw.write(star[i][j]);
    		}
    		bw.write("\n");
    	}
    	
        br.close();
        bw.close();
    }
    
    static void draw(int r, int c, int size, char ch) {
    	if (ch == ' ' || size == 1) {
    		for (int i = r; i < r + size; i++) {
    			for (int j = c; j < c + size; j++) {
    				star[i][j] = ch;
    			}
    		}
    		return;
    	} else {
    		size = size / 3;
    		draw(r, c, size, '*');
    		draw(r, c + size, size, '*');
    		draw(r, c + size * 2, size, '*');
    		draw(r + size, c, size, '*');
    		draw(r + size, c + size, size, ' ');
    		draw(r + size, c + size * 2, size, '*');
    		draw(r + size * 2, c, size, '*');
    		draw(r + size * 2, c + size, size, '*');
    		draw(r + size * 2, c + size * 2, size, '*');
    	}
    }
}