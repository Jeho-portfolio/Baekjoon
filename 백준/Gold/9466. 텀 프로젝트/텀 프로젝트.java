import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            Student[] student = new Student[n + 1];
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);

            for (int j = 1; j <= n; j++) {
                student[j] = new Student(j, Integer.parseInt(st.nextToken()), false, false);
            }

            Queue<Student> queue = new LinkedList<>();
            Queue<Student> list = new LinkedList<>();

            Student last = new Student(0, 0, true, false);

            int ch = 0;

            for (int j = 1; j <= n; j++) {
                if (ch == n) {
                    continue;
                }
                if (!student[j].flag) {
                    queue.add(student[j]);

                    while (!queue.isEmpty()) {
                        Student state = queue.poll();

                        if (state.choice == state.index) {
                            state.flag = true;
                            state.result = true;
                            ch = ch + 1;
                        } else {
                            list.add(state);
                            last = student[state.choice];
                            if (!student[state.choice].flag) {
                                queue.add(student[state.choice]);
                                student[state.choice].flag = true;
                            }
                        }
                    }

                    boolean check = false;
                    while (!list.isEmpty()) {
                        Student tmp = list.poll();
                        if (tmp.index == last.index) {
                            check = true;
                        }

                        if (check) {
                            student[tmp.index].result = true;
                            ch = ch + 1;
                        }
                    }
                }
            }

            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (!student[j].result) {
                    count = count + 1;
                }
            }
            bw.write(count + "\n");
        }

        br.close();
        bw.close();
    }
}

class Student {
    int index;
    int choice;
    boolean flag;
    boolean result;
    Student(int i, int c, boolean f, boolean r) {
        index = i;
        choice = c;
        flag = f;
        result = r;
    }
}