import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String args[]) throws Exception	{
        HashMap<Character, Integer> map = new HashMap<>();
        char tmp = 'A';
        int index = 3;
        for (int i = 0; i < 26; i++) {
            if ('A' + i == 'D') {
                index = index + 1;
            } else if ('A' + i == 'G') {
                index = index + 1;
            } else if ('A' + i == 'J') {
                index = index + 1;
            } else if ('A' + i == 'M') {
                index = index + 1;
            } else if ('A' + i == 'P') {
                index = index + 1;
            } else if ('A' + i == 'T') {
                index = index + 1;
            } else if ('A' + i == 'W') {
                index = index + 1;
            }
            map.put((char) ('A' + i), index);

        }

        String str = br.readLine();

        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            sum = sum + map.get(c);
        }

        bw.write(sum + "\n");

        br.close();
        bw.close();
    }
}