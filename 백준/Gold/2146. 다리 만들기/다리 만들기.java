import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Island[][] island = new Island[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                island[i][j] = new Island(tmp, 0, 0, false);
            }
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int index = 0;

        Queue<Point> queue = new LinkedList<>();
        Queue<Point> list = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (island[i][j].state == 1 && !island[i][j].flag) {
                    index = index + 1;
                    queue.add(new Point(i, j));
                    island[i][j].flag = true;
                    island[i][j].group = index;

                    while (!queue.isEmpty()) {
                        Point current = queue.poll();

                        for (int dir = 0; dir < 4; dir++) {
                            int nx = current.x + dx[dir];
                            int ny = current.y + dy[dir];

                            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                                if (island[nx][ny].state == 1 && !island[nx][ny].flag) {
                                    queue.add(new Point(nx, ny));
                                    island[nx][ny].flag = true;
                                    island[nx][ny].group = index;
                                } else if (island[nx][ny].state == 0 && !island[nx][ny].flag) {
                                    list.add(new Point(current.x, current.y));
                                }
                            }
                        }
                    }
                }
            }
        }

        int bridge = Integer.MAX_VALUE;

        Queue<Point> tmp = new LinkedList<>();

        while (!list.isEmpty()) {
            Stack<Point> stack = new Stack<>();
            boolean check = false;
            Point current = list.poll();
            int mine = island[current.x][current.y].group;
            stack.add(current);
            tmp.add(current);

            while (!stack.isEmpty()) {
                Point now = stack.pop();
                tmp.add(now);

                for (int dir = 0; dir < 4; dir++) {
                    int nx = now.x + dx[dir];
                    int ny = now.y + dy[dir];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        if (island[nx][ny].state == 0 && !island[nx][ny].flag) {
                            island[nx][ny].flag = true;
                            island[nx][ny].count = island[now.x][now.y].count + 1;
                            stack.add(new Point(nx, ny));
                            tmp.add(new Point(nx, ny));
                        } else if (island[nx][ny].state == 1 && island[nx][ny].group != mine) {
                            int length = island[now.x][now.y].count;
                            if (bridge > length) {
                                bridge = length;
                            }
                            check = true;
                        }
                    }
                    if (check) {
                        break;
                    }
                }
            }
            while (!tmp.isEmpty()) {
                Point now = tmp.poll();
                island[now.x][now.y].flag = false;
                island[now.x][now.y].count = 0;
            }
        }

        bw.write(String.valueOf(bridge));

        

        br.close();
        bw.close();
    }
}

class Island {
    int state;
    int group;
    int count;
    boolean flag;

    Island(int s, int g, int c, boolean f) {
        state = s;
        group = g;
        count = c;
        flag = f;
    }
}

class Point {
    int x;
    int y;

    Point(int f, int s) {
        x = f;
        y = s;
    }
}