import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            Field[][] field = new Field[h][w];
            Queue<Point> queue = new LinkedList<>();
            Point human = new Point(0, 0);
            Queue<Point> fire = new LinkedList<>();
            int result = 0;

            for (int j = 0; j < h; j++) {
                str = br.readLine();
                for (int k = 0; k < w; k++) {
                    char c = str.charAt(k);
                    field[j][k] = new Field(c, 0);
                    if (c == '@') {
                        human = new Point(j, k);
                    } else if (c == '*') {
                        fire.add(new Point(j, k));
                    }
                }
            }

            while (!fire.isEmpty()) {
                queue.add(fire.poll());
            }
            queue.add(human);

            while (!queue.isEmpty()) {
                Point current = queue.poll();

                for (int dir = 0; dir < 4; dir++) {
                    int nx = current.x + dx[dir];
                    int ny = current.y + dy[dir];

                    if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                        if (field[nx][ny].state == '.') {
                            field[nx][ny].state = field[current.x][current.y].state;
                            if (field[current.x][current.y].state == '@') {
                                field[nx][ny].count = field[current.x][current.y].count + 1;
                            }
                            queue.add(new Point(nx, ny));
                        }
                    } else {
                        if (field[current.x][current.y].state == '@') {
                            int tmp = field[current.x][current.y].count + 1;
                            if (result == 0) {
                                result = tmp;
                            } else {
                                if (tmp < result) {
                                    result = tmp;
                                }
                            }
                        }
                    }
                }
            }

            if (result == 0) {
                bw.write("IMPOSSIBLE\n");
            } else {
                bw.write(String.valueOf(result) + "\n");
            }
        }

        bw.close();
        br.close();
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
class Field {
    char state;
    int count;
    Field(char first, int second) {
        state = first;
        count = second;
    }
}

