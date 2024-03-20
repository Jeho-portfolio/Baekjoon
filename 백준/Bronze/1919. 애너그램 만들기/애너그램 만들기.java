import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str1 = br.readLine();
        String str2 = br.readLine();
        char[] first = str1.toCharArray();
        char[] second = str2.toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);

        int length1 = first.length;
        int length2 = second.length;
        int index1 = 0, index2 = 0, count = 0;

        while (index1 < length1 && index2 <length2) {
            if (first[index1] == second[index2]) {
                index1 = index1 + 1;
                index2 = index2 + 1;
            } else if (first[index1] < second[index2]) {
                count = count + 1;
                index1 = index1 + 1;
            } else {
                count = count + 1;
                index2 = index2 + 1;
            }
        }

        if (index1 != length1) {
            count = count + (length1 - index1);
        }

        if (index2 != length2) {
            count = count + (length2 - index2);
        }

        bw.write(String.valueOf(count));

        bw.close();
        br.close();
    }
    
}