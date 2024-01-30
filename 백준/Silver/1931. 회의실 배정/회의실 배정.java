import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Conference> list = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			Conference tmp = new Conference(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			list.add(tmp);
		}

		Conference tmp = list.poll();
		int endTime = tmp.end;
		int count = 1;

		while (!list.isEmpty()) {
			tmp = list.poll();
			if (tmp.start >= endTime) {
				count = count + 1;
				endTime = tmp.end;
			}
		}

		bw.write(String.valueOf(count));

		br.close();
		bw.close();
	}
}

class Conference implements Comparable<Conference> {
	int start;
	int end;

	Conference(int first, int second) {
		start = first;
		end = second;
	}

	@Override
	public int compareTo(Conference o) {
		if (this.end != o.end) {
			return this.end - o.end;
		} else {
			return this.start - o.start;
		}
	}
}