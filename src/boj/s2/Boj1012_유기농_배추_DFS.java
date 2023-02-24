package boj.s2;

import java.util.Scanner;

public class Boj1012_유기농_배추_DFS {
	static int M, N;
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

			visited = new boolean[N][M];
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}

	private static void dfs(int i, int j) {
		visited[i][j] = true;

		for (int d = 0; d < 4; d++) {
			int nexti = i + di[d];
			int nextj = j + dj[d];

			if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M && map[nexti][nextj] == 1
					&& !visited[nexti][nextj]) {

				dfs(nexti, nextj);
			}
		}
	}
}
