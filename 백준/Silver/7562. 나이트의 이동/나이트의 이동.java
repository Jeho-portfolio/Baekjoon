import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        StringTokenizer st;

        int[] dx = {2, 2, 1, 1, -1, -1, -2, -2};
        int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int I = Integer.parseInt(br.readLine());
            str = br.readLine();
            st = new StringTokenizer(str);
            Point current = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            str = br.readLine();
            st = new StringTokenizer(str);
            Point target = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            if (current.x == target.x && current.y == target.y) {
                bw.write("0\n");
            } else {
                Board[][] board = new Board[I][I];
                for (int j = 0; j < I; j++) {
                    for (int k = 0; k < I; k++) {
                        board[j][k] = new Board(0);
                    }
                }

                Queue<Point> queue = new LinkedList<>();
                queue.add(current);

                while (!queue.isEmpty()) {
                    Point tmp = queue.poll();
                    for (int dir = 0; dir < 8; dir++) {
                        int nx = tmp.x + dx[dir];
                        int ny = tmp.y + dy[dir];
                        if (nx >= 0 && nx < I && ny >= 0 && ny < I) {
                            if (board[nx][ny].count == 0) {
                                board[nx][ny].count = board[tmp.x][tmp.y].count + 1;
                                queue.add(new Point(nx, ny));
                            }
                        }
                    }
                }

                bw.write(String.valueOf(board[target.x][target.y].count) + "\n");
            }


        }

        bw.close();
        br.close();
    }
}

class Board {
    int count;
    Board(int first) {
        count = first;
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