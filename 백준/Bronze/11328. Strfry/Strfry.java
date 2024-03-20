import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            String first = st.nextToken();
            String second = st.nextToken();

            char[] f = first.toCharArray();
            char[] s = second.toCharArray();
            Arrays.sort(f);
            Arrays.sort(s);
            first = new String(f);
            second = new String(s);

            if (first.equals(second)) {
                bw.write("Possible\n");
            } else {
                bw.write("Impossible\n");
            }
        }

        bw.close();
        br.close();
    }
    
}