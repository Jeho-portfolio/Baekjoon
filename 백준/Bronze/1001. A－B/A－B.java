import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
    
        bw.write(String.valueOf(A - B));
    
        br.close();
        bw.close();
    }    
}
