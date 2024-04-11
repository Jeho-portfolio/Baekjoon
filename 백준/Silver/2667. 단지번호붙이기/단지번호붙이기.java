import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int N = Integer.parseInt(br.readLine());

        Field[][] field = new Field[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = str.charAt(j);
                field[i][j] = new Field(c, false);
            }
        }

        Queue<Point> queue = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!field[i][j].flag && field[i][j].state == '1') {
                    int count = 0;
                    field[i][j].flag = true;
                    count = count + 1;
                    queue.add(new Point(i, j));

                    while (!queue.isEmpty()) {
                        Point current = queue.poll();

                        for (int dir = 0; dir < 4; dir++) {
                            int nx = current.x + dx[dir];
                            int ny = current.y + dy[dir];

                            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                                if (field[nx][ny].state == '1' && !field[nx][ny].flag) {
                                    field[nx][ny].flag = true;
                                    count = count + 1;
                                    queue.add(new Point(nx, ny));
                                }
                            }
                        }
                    }
                    result.add(count);
                }
            }
        }

        Collections.sort(result);
        bw.write(String.valueOf(result.size()) + "\n");
        ListIterator<Integer> iterator = result.listIterator();
        while (iterator.hasNext()) {
            bw.write(iterator.next() + "\n");
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
    boolean flag;
    Field(char first, boolean second) {
        state = first;
        flag = second;
    }
}