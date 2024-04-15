import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Field[][] field = new Field[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                field[i][j] = new Field(tmp, tmp);
            }
        }

        int max = 0;


        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        Queue<Point> queue = new LinkedList<>();

        for (int index = 0; index < 101; index++) {
            Queue<Integer> earth = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (field[i][j].height > index && field[i][j].flag != index) {
                        int count = 0;
                        field[i][j].flag = index;
                        queue.add(new Point(i, j));
                        count = count + 1;

                        while (!queue.isEmpty()) {
                            Point current = queue.poll();

                            for (int dir = 0; dir < 4; dir++) {
                                int nx = current.x + dx[dir];
                                int ny = current.y + dy[dir];

                                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                                    if (field[nx][ny].height > index && field[nx][ny].flag != index) {
                                        field[nx][ny].flag = index;
                                        queue.add(new Point(nx, ny));
                                        count = count + 1;
                                    }
                                }
                            }
                        }
                        earth.add(count);
                    }
                }
            }
            if (earth.size() > max) {
                max = earth.size();
            }
        }

        bw.write(String.valueOf(max));

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
    int height;
    int flag;
    Field(int first, int second) {
        height = first;
        flag = second;
    }
}