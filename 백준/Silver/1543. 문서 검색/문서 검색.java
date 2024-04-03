import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int length = str.length();
        String word = br.readLine();
        int wordLength = word.length();

        str = str.replaceAll(word, "");
        int result = (length - str.length()) / wordLength;

        bw.write(String.valueOf(result));

        bw.close();
        br.close();
    }
}