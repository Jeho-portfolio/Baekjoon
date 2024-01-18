import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		Node[] numberList = new Node[N];

		str = br.readLine();
		st = new StringTokenizer(str);

		for (int i = 0; i < N; i++) {
			numberList[i] = new Node();
			numberList[i].index = i;
			numberList[i].number = Long.parseLong(st.nextToken());
		}

		Deque<Node> deque = new LinkedList<>();

		int index = 0, tmp, first;
		while (true) {
			if (index == 0) {
				deque.add(numberList[index]);
			} else {
				while (deque.size() != 0 && deque.getLast().number > numberList[index].number) {
					deque.removeLast();
				}
				deque.add(numberList[index]);
			}

			first = index - L;
			if (deque.peek().index <= first) {
				deque.removeFirst();
			}

			bw.write(String.valueOf(deque.peekFirst().number) + " ");
			index = index + 1;

			if (index == N) {
				break;
			}
		}

		br.close();
		bw.close();
	}
}

class Node {
	int index;
	long number;
}