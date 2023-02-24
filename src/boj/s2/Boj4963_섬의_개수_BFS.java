package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj4963_섬의_개수_BFS {
	static int W, H, count;
	static int[] di = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dj = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if (W == 0 && H == 0)
				break;

			map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			count = 0;
			visited = new boolean[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
						count++;
					}
				}
			}

			System.out.println(count);
		}
	}

	private static void bfs(int si, int sj) {
		Queue<Point> queue = new LinkedList<>();
		visited[si][sj] = true;
		queue.add(new Point(si, sj));

		while (!queue.isEmpty()) {
			Point now = queue.poll();
			int i, j;
			for (int d = 0; d < 8; d++) {
				i = now.i + di[d];
				j = now.j + dj[d];

				if (i >= 0 && i < H && j >= 0 && j < W && map[i][j] == 1 && !visited[i][j]) {
					visited[i][j] = true;
					queue.add(new Point(i, j));
				}
			}
		}
	}

	static class Point {
		int i;
		int j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
