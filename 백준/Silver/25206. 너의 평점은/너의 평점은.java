import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String args[]) throws Exception	{
        double average = 0;
        double sumSubject = 0;

        for (int i = 0; i < 20; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            st.nextToken();
            double subject = Double.parseDouble(st.nextToken());
            String credit = st.nextToken();
            if (!credit.equals("P")) {
                if (credit.equals("A+")) {
                    sumSubject = sumSubject + subject;
                    average = average + (subject * 4.5);
                } else if (credit.equals("A0")) {
                    sumSubject = sumSubject + subject;
                    average = average + (subject * 4.0);
                } else if (credit.equals("B+")) {
                    sumSubject = sumSubject + subject;
                    average = average + (subject * 3.5);
                } else if (credit.equals("B0")) {
                    sumSubject = sumSubject + subject;
                    average = average + (subject * 3.0);
                } else if (credit.equals("C+")) {
                    sumSubject = sumSubject + subject;
                    average = average + (subject * 2.5);
                } else if (credit.equals("C0")) {
                    sumSubject = sumSubject + subject;
                    average = average + (subject * 2.0);
                } else if (credit.equals("D+")) {
                    sumSubject = sumSubject + subject;
                    average = average + (subject * 1.5);
                } else if (credit.equals("D0")) {
                    sumSubject = sumSubject + subject;
                    average = average + subject;
                } else {
                    sumSubject = sumSubject + subject;
                }
            }
        }
        average = average / sumSubject;

        bw.write(average + "\n");

        br.close();
        bw.close();
    }
}