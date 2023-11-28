import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int number, result = 0;
		String str;
		
		number = Integer.parseInt(br.readLine());
		
		str = br.readLine();
		for (int i = 0; i < number; i++) {
			result = result + Character.getNumericValue(str.charAt(i));	
		}
		
		bw.write(String.valueOf(result));
		bw.flush();
	}

}
