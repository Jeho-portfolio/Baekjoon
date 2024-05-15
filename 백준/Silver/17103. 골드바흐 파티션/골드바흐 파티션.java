import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] number = new int[1000001];
        for (int i = 2; i < 1000001; i++) {
        	number[i] = i;
        }
        
        int index = 2;
        while (index <= 1000) {
        	for (int i = index + 1; i < 1000001; i++) {
        		if (number[i] % index == 0) {
        			number[i] = 0;
        		}
        	}
        	
        	index = index + 1;
        	while (number[index] == 0) {
        		index = index + 1;
        	}
        }
        
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
        	int N = Integer.parseInt(br.readLine());
        	int count = 0;
        	int first = N / 2;
        	int second = N / 2;
        	
        	while (first >= 2) {
        		if (number[first] + number[second] == N) {
        			count = count + 1;
        		}
        		first = first - 1;
        		second = second + 1;
        	}
        	bw.write(count + "\n");
        }
        
        br.close();
        bw.close();
    }
}