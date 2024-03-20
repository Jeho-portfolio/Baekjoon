import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }
        ListIterator<Character> iterator = list.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String tmp = br.readLine();
            StringTokenizer st = new StringTokenizer(tmp);
            String command = st.nextToken();

            if (command.equals("L")) {
                if (iterator.hasPrevious()) {
                    iterator.previous();
                }
            } else if (command.equals("D")) {
                if (iterator.hasNext()) {
                    iterator.next();
                }
            } else if (command.equals("B")) {
                if (iterator.hasPrevious()) {
                    iterator.previous();
                    iterator.remove();
                }
            } else {
                command = st.nextToken();
                iterator.add(command.charAt(0));
            }
        }

        ListIterator<Character> r = list.listIterator();

        while (r.hasNext()) {
            bw.write(r.next());
        }

        bw.close();
        br.close();
    }
    
}