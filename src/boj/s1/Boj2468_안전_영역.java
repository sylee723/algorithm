package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2468_안전_영역 {
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 1;
		boolean[][] sink = new boolean[N][N];
		for (int h = 1; h <= 100; h++) {
			int count = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == h) {
						sink[i][j] = true;
						count++;
					}
				}
			}

			if (count > 0) {
				answer = Math.max(answer, countArea(sink));
			}
		}

		System.out.println(answer);
	}

	private static int countArea(boolean[][] sink) {
		boolean[][] visited = new boolean[sink.length][sink.length];

		int count = 0;
		for (int i = 0; i < sink.length; i++) {
			for (int j = 0; j < sink.length; j++) {
				if (!visited[i][j] && !sink[i][j]) {
					bfs(visited, sink, i, j);
					count++;
				}
			}
		}

		return count;
	}

	private static void bfs(boolean[][] visited, boolean[][] sink, int si, int sj) {
		Queue<Point> queue = new ArrayDeque<>();
		visited[si][sj] = true;
		queue.add(new Point(si, sj));

		int N = sink.length;
		while (!queue.isEmpty()) {
			Point now = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nexti = now.i + di[d];
				int nextj = now.j + dj[d];

				if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < N && !visited[nexti][nextj]
						&& !sink[nexti][nextj]) {
					visited[nexti][nextj] = true;
					queue.add(new Point(nexti, nextj));
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
