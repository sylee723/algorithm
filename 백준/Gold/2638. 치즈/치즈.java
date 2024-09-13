import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		boolean[][] cheese = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					cheese[i][j] = true;
				} else {
					cheese[i][j] = false;
				}
			}
		}

		int[][] airCnt = new int[N][M];
		int time = 0;
		while (true) {
			if (!isLeft(cheese)) {
				break;
			}
			initArr(airCnt);
			countCell(cheese, airCnt);
			melt(cheese, airCnt);
			time++;
		}

		System.out.println(time);
	}

	private static boolean isLeft(boolean[][] cheese) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (cheese[i][j]) {
					return true;
				}
			}
		}

		return false;
	}

	private static void initArr(int[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = 0;
			}
		}
	}

	private static void countCell(boolean[][] cheese, int[][] airCnt) {
		Queue<Point> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];

		visited[0][0] = true;
		queue.add(new Point(0, 0));

		while (!queue.isEmpty()) {
			Point now = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nexti = now.i + di[d];
				int nextj = now.j + dj[d];

				if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M && !visited[nexti][nextj]) {
					if (cheese[nexti][nextj]) {
						airCnt[nexti][nextj]++;
					} else {
						visited[nexti][nextj] = true;
						queue.add(new Point(nexti, nextj));
					}
				}
			}
		}
	}

	private static void melt(boolean[][] cheese, int[][] airCnt) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (cheese[i][j] && airCnt[i][j] >= 2) {
					cheese[i][j] = false;
				}
			}
		}
	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}