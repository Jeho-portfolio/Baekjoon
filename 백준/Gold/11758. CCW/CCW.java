import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Point[] p = new Point[3];

		for (int i = 0; i < 3; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			p[i] = new Point();
			p[i].x = Integer.parseInt(st.nextToken());
			p[i].y = Integer.parseInt(st.nextToken());
		}

		int result = Point.circulateCCW(p[0], p[1], p[2]);

		if (result > 0) {
			bw.write("1");
		} else if (result < 0) {
			bw.write("-1");
		} else {
			bw.write("0");
		}

		br.close();
		bw.close();
	}
}

class Point {
	int x, y;

	static int circulateCCW(Point a, Point b, Point c) {
		int result = ((a.x * b.y) + (b.x * c.y) + (c.x * a.y)) - ((b.x * a.y) + (c.x * b.y) + (a.x * c.y));
		return result;
	}
}
