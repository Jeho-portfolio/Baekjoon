import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] list = new int[n];
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);

        int x = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < list.length; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if (list[i] + list[j] == x) {
                    count = count + 1;
                } else if (list[i] + list[j] > x) {
                    break;
                }
            }
        }

        bw.write(String.valueOf(count));

        bw.close();
        br.close();
    }
    
}