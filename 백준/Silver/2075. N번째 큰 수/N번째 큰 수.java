import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		PriorityQueue<Point> pq = new PriorityQueue<>();
		for (int j = 0; j < N; j++) {
			pq.add(new Point(N - 1, j, board[N - 1][j]));
		}

		Point now = null;
		for (int k = 0; k < N; k++) {
			now = pq.poll();
			if (now.i > 0) {
				pq.add(new Point(now.i - 1, now.j, board[now.i - 1][now.j]));
			}
		}

		System.out.println(now.num);
	}

	static class Point implements Comparable<Point> {
		int i, j, num;

		public Point(int i, int j, int num) {
			this.i = i;
			this.j = j;
			this.num = num;
		}

		@Override
		public int compareTo(Point o) {
			return -(this.num - o.num);
		}
	}
}