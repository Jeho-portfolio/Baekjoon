import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int length = str.length();
        int[] alphabet = new int[26];

        for (int i = 0; i < 26; i++) {
            alphabet[i] = 0;
        }

        for (int i = 0; i < length; i++) {
            int number = str.charAt(i) - 'a';
            alphabet[number] = alphabet[number] + 1;
        }

        for (int i = 0; i < 26; i++) {
            bw.write(String.valueOf(alphabet[i]) + " ");
        }

        bw.close();
        br.close();
    }
    
}