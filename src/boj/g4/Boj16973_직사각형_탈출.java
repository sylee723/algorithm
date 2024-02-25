package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj16973_직사각형_탈출 {
	static int N, M, H, W;
	static int[][] board;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N + 1][M + 1];

		ArrayList<Point> wall = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) {
					wall.add(new Point(i, j));
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		int si = Integer.parseInt(st.nextToken());
		int sj = Integer.parseInt(st.nextToken());
		int fi = Integer.parseInt(st.nextToken());
		int fj = Integer.parseInt(st.nextToken());

		boardSetting(wall);
		System.out.println(bfs(si, sj, fi, fj));
	}

	private static void boardSetting(ArrayList<Point> wall) {
		for (Point w : wall) {
			for (int i = Math.max(1, w.i - H + 1); i <= w.i; i++) {
				for (int j = Math.max(1, w.j - W + 1); j <= w.j; j++) {
					board[i][j] = 1;
				}
			}
		}

		for (int i = N - H + 2; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				board[i][j] = 1;
			}
		}

		for (int j = M - W + 2; j <= M; j++) {
			for (int i = 1; i < N - H + 2; i++) {
				board[i][j] = 1;
			}
		}
	}

	private static int bfs(int si, int sj, int fi, int fj) {
		Queue<Point> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[N + 1][M + 1];
		visited[si][sj] = true;
		queue.add(new Point(si, sj));

		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Point now = queue.poll();
				if (now.i == fi && now.j == fj) {
					return count;
				}

				for (int d = 0; d < 4; d++) {
					int nexti = now.i + di[d];
					int nextj = now.j + dj[d];

					if (nexti > 0 && nexti <= N && nextj > 0 && nextj <= M && board[nexti][nextj] == 0
							&& !visited[nexti][nextj]) {
						visited[nexti][nextj] = true;
						queue.add(new Point(nexti, nextj));
					}
				}
			}

			count++;
		}

		return -1;
	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
