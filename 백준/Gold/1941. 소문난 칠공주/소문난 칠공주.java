import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static char[][] list = new char[5][5];
    static boolean[][] visited = new boolean[5][5];

    static Point[] arr = new Point[7];

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int count;
    
    static PriorityQueue<Point> queue;
    static Set<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < 5; j++) {
                list[i][j] = str.charAt(j);
            }
        }

        sequence(0);

        bw.write(String.valueOf(set.size()));

        br.close();
        bw.close();
    }

    static void sequence(int k) {
        if (k == 7) {
            count = 0;
            queue = new PriorityQueue<>();
            for (int i = 0; i < 7; i++) {
                queue.add(arr[i]);
                if (arr[i].ch == 'S') {
                    count = count + 1;
                }
            }
            if (count >= 4) {
                StringBuilder sb = new StringBuilder("");
                while (!queue.isEmpty()) {
                    Point tmp = queue.poll();
                    sb.append(tmp.x + " " + tmp.y + " ");
                }
                set.add(sb.toString());
            }
            return;
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (k == 0) {
                    if (!visited[i][j]) {
                        arr[k] = new Point(list[i][j], i, j);
                        visited[i][j] = true;
                        sequence(k + 1);
                        visited[i][j] = false;
                    }
                } else {
                    if (!visited[i][j]) {
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = i + dx[dir];
                            int ny = j + dy[dir];
                            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                                if (visited[nx][ny]) {
                                    arr[k] = new Point(list[i][j], i, j);
                                    visited[i][j] = true;
                                    sequence(k + 1);
                                    visited[i][j] = false;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

class Point implements Comparable<Point> {
    char ch;
    int x;
    int y;

    Point(char tmp, int f, int s) {
        ch = tmp;
        x = f;
        y = s;
    }

    @Override
    public int compareTo(Point o) {
        int result = Integer.MIN_VALUE;
        if (o.x < x) {
            result = 2;
        } else if (o.x == x) {
            if (o.y < y) {
                result = 1;
            } else if (o.y == y) {
                result = -1;
            } else {
                result = -2;
            }
        } else {
            result = -3;
        }
        return result;
    }
}