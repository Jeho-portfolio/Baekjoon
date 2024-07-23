import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String args[]) throws Exception	{
		int N = Integer.parseInt(br.readLine());
		
		HashSet<Integer> set = new HashSet<>();
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		set.add(666);
		
		for (int i = 0; i <= 9; i++) {
			set.add((6660 + i));
		}
		for (int i = 1; i <= 9; i++) {
			set.add((i * 1000 + 666));
		}
		
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				set.add((66600 + i * 10 + j));	
			}
		}
		for (int i = 1; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				set.add((6660 + i * 10000 + j));	
			}
		}
		for (int i = 1; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				set.add((666 + i * 10000 + j * 1000));	
			}
		}
		
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k <= 9; k++) {
					set.add((666000 + i * 100 + j * 10 + k));
				}	
			}
		}
		for (int i = 1; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k <= 9; k++) {
					set.add((66600 + i * 100000 + j * 10 + k));
				}	
			}
		}
		for (int i = 1; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k <= 9; k++) {
					set.add((6660 + i * 100000 + j * 10000 + k));
				}	
			}
		}
		for (int i = 1; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k <= 9; k++) {
					set.add((666 + i * 100000 + j * 10000 + k * 1000));
				}	
			}
		}
		
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k <= 9; k++) {
					for (int l = 0; l <= 9; l++) {
						set.add((6660000 + i * 1000 + j * 100 + k * 10 + l));	
					}
				}	
			}
		}
		for (int i = 1; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k <= 9; k++) {
					for (int l = 0; l <= 9; l++) {
						set.add((666000 + i * 1000000 + j * 100 + k * 10 + l));	
					}
				}	
			}
		}
		for (int i = 1; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k <= 9; k++) {
					for (int l = 0; l <= 9; l++) {
						set.add((66600 + i * 1000000 + j * 100000 + k * 10 + l));	
					}
				}	
			}
		}
		for (int i = 1; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k <= 9; k++) {
					for (int l = 0; l <= 9; l++) {
						set.add((6660 + i * 1000000 + j * 100000 + k * 10000 + l));	
					}
				}	
			}
		}
		for (int i = 1; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k <= 9; k++) {
					for (int l = 0; l <= 9; l++) {
						set.add((666 + i * 1000000 + j * 100000 + k * 10000 + l * 1000));	
					}
				}	
			}
		}
		
		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()) {
			queue.add(iterator.next());
		}
		
		int tmp = 0;
		for (int i = 1; i <= N; i++) {
			tmp = queue.poll();
		}
		
		bw.write(String.valueOf(tmp));
		
		br.close();
		bw.close();
	}
}