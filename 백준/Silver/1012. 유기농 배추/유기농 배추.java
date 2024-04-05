import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            Field[][] field = new Field[M][N];
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    field[j][k] = new Field(0, false);
                }
            }

            int count = 0;
            Queue<Point> queue = new LinkedList<>();
            for (int j = 0; j < K; j++) {
                str = br.readLine();
                st = new StringTokenizer(str);
                Point current = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                field[current.x][current.y].cabbage = 1;
                queue.add(current);
                count = count + 1;
            }

            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};

            while (!queue.isEmpty()) {
                Point state = queue.peek();
                if (field[state.x][state.y].flag) {
                    queue.poll();
                } else {
                    queue.poll();
                    field[state.x][state.y].flag = true;

                    Queue<Point> tmp = new LinkedList<>();
                    tmp.add(state);

                    while (!tmp.isEmpty()) {
                        Point pt = tmp.poll();
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = pt.x + dx[dir];
                            int ny = pt.y + dy[dir];

                            if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                                if (field[nx][ny].cabbage == 1 && !field[nx][ny].flag) {
                                    field[nx][ny].flag = true;
                                    count = count - 1;
                                    tmp.add(new Point(nx, ny));
                                }
                            }
                        }
                    }
                }
            }
            bw.write(String.valueOf(count) + "\n");
        }

        bw.close();
        br.close();
    }
}

class Field {
    int cabbage;
    boolean flag;
    Field(int first, boolean second) {
        cabbage = first;
        flag = second;
    }
}

class Point {
    int x;
    int y;
    Point(int first, int second) {
        x = first;
        y = second;
    }
}