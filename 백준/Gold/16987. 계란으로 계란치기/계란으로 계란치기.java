import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
	static int N;
	static Egg[] egg, middle;
	static int[] list;
	static int count = 0, max = 0;
	
    public static void main(String[] args) throws IOException {
    	N = Integer.parseInt(br.readLine());
    
    	egg = new Egg[N];
    	
    	list = new int[N];
    	middle = new Egg[N];
    	
    	for (int i = 0; i < N; i++) {
    		String str = br.readLine();
    		StringTokenizer st = new StringTokenizer(str);
    		egg[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    		middle[i] = new Egg(egg[i].durability, egg[i].weight);
    	}
    	
    	sequence(0);
    	
    	bw.write(String.valueOf(max));
    	
        br.close();
        bw.close();
    }
    
    static void sequence(int k) throws IOException {
    	if (k == N) {    		
    		for (int i = 0; i < N; i++) {
    			middle[i].durability = egg[i].durability;
    		}
    		
    		for (int i = 0; i < N; i++) {
    			if (middle[i].durability > 0 && middle[list[i]].durability > 0) {
    				middle[i].durability = middle[i].durability - middle[list[i]].weight;
    				middle[list[i]].durability = middle[list[i]].durability - middle[i].weight;
    			}
    		}
    		
    		for (int i = 0; i < N; i++) {
    			if (middle[i].durability <= 0) {
    				count = count + 1;
    			}
    		}
    		
    		if (max < count) {
    			max = count;
    		}
    		count = 0;
    		return;
    	}
    	
    	for (int i = 0; i < N; i++) {
    		if (k != i) {
    			list[k] = i;
    			sequence(k + 1);
    		}
    	}
    }
}

class Egg {
	int durability;
	int weight;
	
	Egg(int d, int w) {
		durability = d;
		weight = w;
	}
}