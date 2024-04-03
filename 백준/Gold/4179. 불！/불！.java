import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Maze[][] maze = new Maze[R][C];

        Queue<Pair> queue = new LinkedList<>();
        Pair start = new Pair(0,0);

        for (int i = 0; i < R; i++) {
            str = br.readLine();
            for (int j = 0; j < C; j++) {
                char tmp = str.charAt(j);
                maze[i][j] = new Maze(tmp, 0);
                if (tmp == 'F') {
                    queue.add(new Pair(i, j));
                } else if (tmp == 'J') {
                    start = new Pair(i,j);
                }
            }
        }
        queue.add(start);

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int time = -1;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = current.x + dx[dir];
                int ny = current.y + dy[dir];

                if (maze[current.x][current.y].state == 'J') {
                    int next = maze[current.x][current.y].length + 1;
                    if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                        if (maze[nx][ny].state != '.') {
                            continue;
                        }
                        maze[nx][ny].state = 'J';
                        maze[nx][ny].length = next;
                        queue.add(new Pair(nx, ny));
                    } else {
                        time = next;
                        break;
                    }
                } else {
                    if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                        continue;
                    }
                    if (maze[nx][ny].state != '.') {
                        continue;
                    }
                    maze[nx][ny].state = 'F';
                    queue.add(new Pair(nx, ny));
                }
            }

            if (time != -1) {
                break;
            }
        }

        if (time == -1) {
            bw.write("IMPOSSIBLE");
        } else {
            bw.write(String.valueOf(time));
        }

        bw.close();
        br.close();
    }
}
class Pair {
    int x;
    int y;
    Pair(int first, int second) {
        x = first;
        y = second;
    }
}

class Maze {
    char state;
    int length;
    Maze(char first, int second) {
        state = first;
        length = second;
    }
}
