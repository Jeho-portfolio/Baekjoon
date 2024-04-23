import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		LinkedList<String> list = new LinkedList<>();
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String foxSay = "";
			while (true) {				
				String str = br.readLine();
				if (str.equals("what does the fox say?")) {
					break;
				} else if (!str.contains("goes")) {
					foxSay = str;
				} else {
					String[] tmp = str.split(" ");
					list.add(tmp[2]);
				}
			}
			
			String[] sound = foxSay.split(" ");
			ListIterator<String> iterator = list.listIterator();
			while (iterator.hasNext()) {
				String tmp = iterator.next();
				for (int index = 0; index < sound.length; index++) {
					if (sound[index].equals(tmp)) {
						sound[index] = "!";
					}
				}
			}
			
			for (int index = 0; index < sound.length; index++) {
				if (!sound[index].equals("!")) {
					bw.write(sound[index] + " ");
				}
			}
			bw.write("\n");
		}
		
		br.close();
		bw.close();
	}
}