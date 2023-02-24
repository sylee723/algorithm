package boj.s2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj1012_유기농_배추_BFS {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();

		for (int tc = 0; tc < TC; tc++) {
			M = sc.nextInt();
			N = sc.nextInt();
			int K = sc.nextInt();
			map = new int[N][M];

			for (int k = 0; k < K; k++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[y][x] = 1;
			}

			int count = 0;
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}

	private static void bfs(int i, int j) {
		Queue<Point> queue = new LinkedList<>();

		visited[i][j] = true;
		queue.add(new Point(i, j));

		while (!queue.isEmpty()) {
			Point now = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nexti = now.i + di[d];
				int nextj = now.j + dj[d];

				if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M && map[nexti][nextj] == 1
						&& !visited[nexti][nextj]) {
					visited[nexti][nextj] = true;
					queue.add(new Point(nexti, nextj));
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
