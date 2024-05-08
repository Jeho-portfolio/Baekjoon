import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        Field[][][] field = new Field[K + 1][H][W];

        for (int i = 0; i < H; i++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            for (int j = 0; j < W; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                for (int h = 0; h <= K; h++) {
                    field[h][i][j] = new Field(tmp, 0, false, 0);
                }
            }
        }

        Queue<Point> queue = new LinkedList<>();
        field[0][0][0].flag = true;
        queue.add(new Point(0, 0, 0));

        int[] dx = {0, 1, 0, -1, 1, 2, 2, 1, -1, -2, -2, -1};
        int[] dy = {1, 0, -1, 0, 2, 1, -1, -2, -2, -1, 1, 2};

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int dir = 0; dir < 12; dir++) {
                if (dir < 4) {
                    int nz = current.z;
                    int nx = current.x + dx[dir];
                    int ny = current.y + dy[dir];
                    if (nx >= 0 && nx < H && ny >= 0 && ny < W) {
                        if (!field[nz][nx][ny].flag && field[nz][nx][ny].state == 0) {
                            field[nz][nx][ny].monkey = field[nz][current.x][current.y].monkey;
                            field[nz][nx][ny].count = field[nz][current.x][current.y].count + 1;
                            field[nz][nx][ny].flag = true;
                            queue.add(new Point(nz, nx, ny));
                        }
                    }
                } else {
                    if (field[current.z][current.x][current.y].monkey < K) {
                        int nz = current.z + 1;
                        int nx = current.x + dx[dir];
                        int ny = current.y + dy[dir];
                        if (nx >= 0 && nx < H && ny >= 0 && ny < W) {
                            if (!field[nz][nx][ny].flag && field[nz][nx][ny].state == 0) {
                                field[nz][nx][ny].monkey = field[current.z][current.x][current.y].monkey + 1;
                                field[nz][nx][ny].count = field[current.z][current.x][current.y].count + 1;
                                field[nz][nx][ny].flag = true;
                                queue.add(new Point(nz, nx, ny));
                            }
                        }
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;
        boolean check = false;
        if (W == 1 && H == 1) {
            bw.write("0");
        } else {
            for (int i = 0; i <= K; i++) {
                if (field[i][H - 1][W - 1].flag && field[i][H - 1][W - 1].count != 0) {
                    check = true;
                    if (field[i][H - 1][W - 1].count < result) {
                        result = field[i][H - 1][W - 1].count;
                    }
                }
            }

            if (check) {
                bw.write(String.valueOf(result));
            } else {
                bw.write("-1");
            }
        }

        br.close();
        bw.close();
    }
}

class Field {
    int state;
    int count;
    boolean flag;
    int monkey;

    Field(int s, int c, boolean f, int m) {
        state = s;
        count = c;
        flag = f;
        monkey = m;
    }
}

class Point {
    int z;
    int x;
    int y;

    Point(int h, int f, int s) {
        z = h;
        x = f;
        y = s;
    }
}