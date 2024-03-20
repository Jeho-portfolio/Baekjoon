import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            char[] ch = str.toCharArray();
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> iterator = list.listIterator();

            for (int j = 0; j < ch.length; j++) {
                if (ch[j] == '<') {
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                    }
                } else if (ch[j] == '>') {
                    if (iterator.hasNext()) {
                        iterator.next();
                    }
                } else if (ch[j] == '-') {
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                        iterator.remove();
                    }
                } else {
                    iterator.add(ch[j]);
                }
            }

            ListIterator<Character> r = list.listIterator();
            while (r.hasNext()){
                bw.write(r.next());
            }
            bw.write("\n");
        }

        bw.close();
        br.close();
    }
    
}