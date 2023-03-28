package boj.g5;

import java.util.Scanner;

public class Boj17070_파이프_옮기기_1_DP {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		Pipe[][] memo = new Pipe[N][N];
		memo[0][1] = new Pipe(1, 0, 0);
		for (int i = 1; i < N; i++) {
			memo[i][1] = new Pipe(0, 0, 0);
		}
		int pipe1, pipe2, pipe3;
		for (int i = 0; i < N; i++) {
			for (int j = 2; j < N; j++) {
				if (map[i][j] == 1)
					continue;
				pipe1 = 0;
				pipe2 = 0;
				pipe3 = 0;

				if (map[i][j - 1] == 0) {
					pipe1 = memo[i][j - 1].p1 + memo[i][j - 1].p3;
				}
				if (i - 1 >= 0 && map[i - 1][j] == 0) {
					pipe2 = memo[i - 1][j].p2 + memo[i - 1][j].p3;
				}
				if (i - 1 >= 0 && map[i - 1][j - 1] == 0 && map[i - 1][j] == 0 && map[i][j - 1] == 0) {
					pipe3 = memo[i - 1][j - 1].p1 + memo[i - 1][j - 1].p2 + memo[i - 1][j - 1].p3;
				}

				memo[i][j] = new Pipe(pipe1, pipe2, pipe3);
			}
		}
		int answer = 0;
		if (memo[N - 1][N - 1] != null) {
			answer = memo[N - 1][N - 1].p1 + memo[N - 1][N - 1].p2 + memo[N - 1][N - 1].p3;
		}
		System.out.println(answer);
	}

	static class Pipe {
		int p1; // 가로
		int p2; // 세로
		int p3; // 대각선

		public Pipe(int p1, int p2, int p3) {
			super();
			this.p1 = p1;
			this.p2 = p2;
			this.p3 = p3;
		}

	}
}
