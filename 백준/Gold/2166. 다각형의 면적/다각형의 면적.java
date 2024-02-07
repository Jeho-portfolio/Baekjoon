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

		int N = Integer.parseInt(br.readLine());
		Node[] list = new Node[N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			double f = Double.parseDouble(st.nextToken());
			double s = Double.parseDouble(st.nextToken());
			list[i] = new Node(f, s);
		}

		int first, second;
		double sum = 0;
		for (int i = 0; i < N; i++) {
			if (i != N - 1) {
				first = i;
				second = i + 1;
			} else {
				first = i;
				second = 0;
			}
			sum = sum + (((list[first].x * list[second].y) - (list[second].x * list[first].y)) / 2);
		}
		sum = Math.abs(sum);
		bw.write(String.format("%.1f", sum));

		br.close();
		bw.close();
	}
}

class Node {
	double x, y;

	public Node(double first, double second) {
		x = first;
		y = second;
	}
}