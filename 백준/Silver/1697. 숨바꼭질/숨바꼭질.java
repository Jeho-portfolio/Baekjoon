import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        State[] state = new State[200000];
        for (int i = 0; i < 200000; i++) {
            if (i == N) {
                state[i] = new State(N, 0);
            } else if (i == K) {
                state[i] = new State(K, 0);
            } else {
                state[i] = new State(-1, 0);
            }
        }

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(N, 0));
        boolean flag = false;
        if (N != K) {
            while (!queue.isEmpty()) {
                Point current = queue.poll();

                for (int i = 0; i < 3; i++) {
                    Point tmp = new Point(current.x, current.count);
                    if (i == 0) {
                        tmp.x = tmp.x - 1;
                    } else if (i == 1) {
                        tmp.x = tmp.x + 1;
                    } else {
                        tmp.x = tmp.x * 2;
                    }

                    if (tmp.x >= 0 && tmp.x < 200000) {
                        if (state[tmp.x].time == 0) {
                            tmp.count = tmp.count + 1;
                            state[tmp.x].time = tmp.count;
                            if (tmp.x == K) {
                                flag = true;
                            }
                            queue.add(tmp);
                        }
                    }
                    if (flag) {
                        break;
                    }
                }
            }
        }

        bw.write(String.valueOf(state[K].time));

        bw.close();
        br.close();
    }
}

class Point {
    int x;
    int count;
    Point(int first, int second) {
        x = first;
        count = second;
    }
}
class State {
    int point;
    int time;
    State(int first, int second) {
        point = first;
        time = second;
    }
}