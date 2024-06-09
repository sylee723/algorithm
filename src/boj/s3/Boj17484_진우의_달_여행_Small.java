package boj.s3;

import java.util.Scanner;

public class Boj17484_진우의_달_여행_Small {
	static int N, M, answer;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		answer = Integer.MAX_VALUE;
		for (int j = 0; j < M; j++) {
			dfs(0, j, 2, 0);
		}

		System.out.println(answer);
	}

	private static void dfs(int i, int j, int dir, int sum) {
		if (i == N) {
			answer = Math.min(answer, sum);
			return;
		}

		for (int d = -1; d <= 1; d++) {
			if (dir == d || j + d < 0 || j + d >= M) {
				continue;
			}

			dfs(i + 1, j + d, d, sum + map[i][j]);
		}
	}
}
