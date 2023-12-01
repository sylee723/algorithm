package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj14940_쉬운_최단거리 {
	static int n, m;
	static int[][] map;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		Point start = null;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 2) {
					start = new Point(i, j);
				} else if (num == 1) {
					num = -1;
				}
				map[i][j] = num;
			}
		}

		bfs(start);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void bfs(Point start) {
		boolean[][] visited = new boolean[n][m];
		Queue<Point> queue = new ArrayDeque<>();

		visited[start.i][start.j] = true;
		queue.add(start);

		int dist = 0;
		int nexti, nextj;
		int size;
		while (!queue.isEmpty()) {
			size = queue.size();
			for (int s = 0; s < size; s++) {
				Point now = queue.poll();
				map[now.i][now.j] = dist;

				for (int d = 0; d < 4; d++) {
					nexti = now.i + di[d];
					nextj = now.j + dj[d];

					if (nexti >= 0 && nexti < n && nextj >= 0 && nextj < m && !visited[nexti][nextj]
							&& map[nexti][nextj] == -1) {
						visited[nexti][nextj] = true;
						queue.add(new Point(nexti, nextj));
					}
				}
			}
			dist++;
		}
	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}
}
