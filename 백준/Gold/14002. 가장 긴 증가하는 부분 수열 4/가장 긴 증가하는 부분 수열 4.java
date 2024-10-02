import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String args[]) throws Exception	{
        int N = Integer.parseInt(br.readLine());

        int[] list = new int[N];
        int[] result = new int[N];
        int[] count = new int[N];
        int[] pre = new int[N];

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            result[i] = list[i];
            count[i] = 1;
            pre[i] = -1;
        }

        int mc = 0;
        int start = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (list[j] < list[i]) {
                    if (count[i] < count[j] + 1) {
                        count[i] = count[j] + 1;
                        pre[i] = j;
                    }

                    if (mc < count[i]) {
                        mc = count[i];
                        start = i;
                    }
                }
            }
        }

        Stack<Integer> stack = new Stack<>();
        while (start != -1) {
            stack.push(list[start]);
            start = pre[start];
        }
        bw.write(stack.size() + "\n");
        while (!stack.isEmpty()) {
            bw.write(stack.pop() + " ");
        }

        br.close();
        bw.close();
    }
}