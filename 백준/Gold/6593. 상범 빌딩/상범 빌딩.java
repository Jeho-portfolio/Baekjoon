import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            Building[][][] building = new Building[L][R][C];

            Point start = new Point(-1, -1, -1);
            Point end = new Point(-1, -1, -1);

            for (int l = 0; l < L; l++) {
                for (int r = 0; r < R; r++) {
                    String line = br.readLine();
                    for (int c = 0; c < C; c++) {
                        char ch = line.charAt(c);
                        building[l][r][c] = new Building(ch, 0);
                        if (ch == 'S') {
                            start.ll = l;
                            start.rr = r;
                            start.cc = c;
                        } else if (ch == 'E') {
                            end.ll = l;
                            end.rr = r;
                            end.cc = c;
                        }
                    }
                }
                br.readLine();
            }

            Queue<Point> queue = new LinkedList<>();
            queue.add(start);

            int[] dx = {0, 1, 0, -1, 0, 0};
            int[] dy = {1, 0, -1, 0, 0, 0};
            int[] dz = {0, 0, 0, 0, 1, -1};

            while (!queue.isEmpty()) {
                Point current = queue.poll();

                for (int dir = 0; dir < 6; dir++) {
                    int nx = current.rr + dx[dir];
                    int ny = current.cc + dy[dir];
                    int nz = current.ll + dz[dir];

                    if (nx >= 0 && nx < R && ny >= 0 && ny < C && nz >= 0 && nz < L) {
                        if ((building[nz][nx][ny].state == '.' || building[nz][nx][ny].state == 'E') && building[nz][nx][ny].count == 0) {
                            building[nz][nx][ny].count = building[current.ll][current.rr][current.cc].count + 1;
                            queue.add(new Point(nz, nx, ny));
                        }
                    }
                }
            }
            if (building[end.ll][end.rr][end.cc].count == 0) {
                bw.write("Trapped!\n");
            } else {
                bw.write("Escaped in " + building[end.ll][end.rr][end.cc].count + " minute(s).\n");
            }
        }



        bw.close();
        br.close();
    }
}

class Building {
    char state;
    int count;
    Building(char first, int second) {
        state = first;
        count = second;
    }
}

class Point {
    int ll;
    int rr;
    int cc;
    Point(int first, int second, int third) {
        ll = first;
        rr = second;
        cc = third;
    }
}