import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception	{
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < N; i++) {
            boolean check = true;

            String str = br.readLine();
            int l = str.length();

            boolean[] flag = new boolean[26];

            char before = 'a';

            for (int index = 0; index < l; index++) {
                char c = str.charAt(index);
                if (index == 0) {
                    flag[c - 'a'] = true;
                    before = c;
                } else {
                    if (c != before) {
                        if (!flag[c - 'a']) {
                            flag[c - 'a'] = true;
                            before = c;
                        } else {
                            check = false;
                            break;
                        }
                    }
                }
            }
            if (check) {
                count = count + 1;
            }
        }

        bw.write(String.valueOf(count));

        br.close();
        bw.close();
    }
}