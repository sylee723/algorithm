package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 진행 중
public class Boj4485_녹색_옷_입은_애가_젤다지 {
	static int N, minRupee;
	static int[][] map;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 0;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			map = new int[N][N];
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			minRupee = Integer.MAX_VALUE;
			bfs();

			System.out.println("Problem " + (++tc) + ": " + minRupee);
		}
	}

	private static void bfs() {
		Queue<Point> queue = new ArrayDeque<>();
		int[][] visited = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j] = Integer.MAX_VALUE;
			}
		}
		queue.add(new Point(0, 0, map[0][0]));
		visited[0][0] = map[0][0];

		while (!queue.isEmpty()) {
			Point now = queue.poll();
			System.out.println("i, j, r: " + now.i + ", " + now.j + ", " + now.rupee);
			if (now.i == N - 1 && now.j == N - 1) {
				minRupee = Math.min(now.rupee, minRupee);
				break;
			}
			for (int d = 0; d < 4; d++) {
				int nexti = now.i + di[d];
				int nextj = now.j + dj[d];

				if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < N) {
					int nextr = now.rupee + map[nexti][nextj];
					if (visited[nexti][nextj] > nextr) {
						visited[nexti][nextj] = nextr;
						queue.add(new Point(nexti, nextj, nextr));
					}
				}
			}
		}
	}

	static class Point {
		int i, j, rupee;

		@Override
		public String toString() {
			return "Point [i=" + i + ", j=" + j + ", rupee=" + rupee + "]";
		}

		public Point(int i, int j, int rupee) {
			super();
			this.i = i;
			this.j = j;
			this.rupee = rupee;
		}
	}
}
