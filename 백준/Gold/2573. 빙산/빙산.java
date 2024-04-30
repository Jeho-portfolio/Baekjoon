import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Block[][] block = new Block[N][M];
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            for (int j = 0; j < M; j++) {
                block[i][j] = new Block(Integer.parseInt(st.nextToken()), 0, false);
            }
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int year = 0;
        int count = -1;
        boolean check = false;

        while (true) {
            count = 0;
            check = false;
            Queue<Point> queue = new LinkedList<>();
            Queue<Point> list = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (block[i][j].state != 0 && !block[i][j].flag) {
                        check = true;
                        queue.add(new Point(i, j));
                        block[i][j].flag = true;
                        list.add(new Point(i, j));
                        count = count + 1;

                        while (!queue.isEmpty()) {
                            Point current = queue.poll();

                            for (int dir = 0; dir < 4; dir++) {
                                int nx = current.x + dx[dir];
                                int ny = current.y + dy[dir];

                                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                                    if (block[nx][ny].state != 0 && !block[nx][ny].flag) {
                                        queue.add(new Point(nx, ny));
                                        block[nx][ny].flag = true;
                                        list.add(new Point(nx, ny));
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (count >= 2 || !check) {
                break;
            } else {
                while (!list.isEmpty()) {
                    Point tmp = list.poll();
                    block[tmp.x][tmp.y].flag = false;
                }
            }

            Queue<Point> field = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (block[i][j].state != 0) {
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = i + dx[dir];
                            int ny = j + dy[dir];

                            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                                if (block[nx][ny].state == 0) {
                                    block[i][j].ice = block[i][j].ice + 1;
                                    field.add(new Point(i, j));
                                }
                            }
                        }
                    }
                }
            }

            while (!field.isEmpty()) {
                Point index = field.poll();
                block[index.x][index.y].state = block[index.x][index.y].state - block[index.x][index.y].ice;
                if (block[index.x][index.y].state < 0) {
                    block[index.x][index.y].state = 0;
                }
                block[index.x][index.y].ice = 0;
            }
            year = year + 1;
        }

        if (count >= 2) {
            bw.write(String.valueOf(year));
        } else {
            bw.write("0");
        }

        br.close();
        bw.close();
    }
}

class Block {
    int state;
    int ice;
    boolean flag;

    Block(int s, int i, boolean f) {
        state = s;
        ice = i;
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