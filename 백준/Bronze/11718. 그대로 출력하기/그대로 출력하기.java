import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception   {
    	while (true) {
    		String str = br.readLine();
    		if (str != null) {
    			bw.write(str + "\n");
    		} else {
    			break;
    		}
    	}
    	
        br.close();
        bw.close();
    }
}