import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M, length = Integer.MAX_VALUE;
    static int[][] field;
    static ArrayList<Point> house = new ArrayList<>();
    static ArrayList<Point> chicken = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        field = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            for (int j = 1; j <= N; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
                if (field[i][j] == 1) {
                    house.add(new Point(i, j));
                } else if (field[i][j] == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }
        
        visited = new boolean[chicken.size()];

        sequence(0, 0);

        bw.write(String.valueOf(length));

        br.close();
        bw.close();
    }

    static void sequence(int count, int k) throws IOException {
        if (count == M) {
            int sum = 0;
            for (int index = 0; index < house.size(); index++) {
                int l = Integer.MAX_VALUE;
                for (int i = 0; i < chicken.size(); i++) {
                	if(visited[i]) {
                		int tmp = Math.abs(house.get(index).x - chicken.get(i).x) + Math.abs(house.get(index).y - chicken.get(i).y);
                        if (tmp < l) {
                            l = tmp;
                        }	
                	}                	
                }
                sum = sum + l;
            }

            if (sum < length) {
                length = sum;
            }
            return;
        }

        for (int i = k; i < chicken.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                sequence(count + 1, i + 1);
                visited[i] = false;
            }
        }
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