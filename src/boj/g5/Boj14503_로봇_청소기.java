package boj.g5;

import java.util.Scanner;

public class Boj14503_로봇_청소기 {
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };
	static int N, M;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int nowi = sc.nextInt();
		int nowj = sc.nextInt();
		int d = sc.nextInt();

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int cleanCnt = 0;
		while (true) {
			if (map[nowi][nowj] == 0) {
				map[nowi][nowj] = -1; // 청소
				cleanCnt++;
			}
			if (!remain(nowi, nowj)) {
				int nexti = nowi - di[d];
				int nextj = nowj - dj[d];
				if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M && map[nexti][nextj] <= 0) {
					nowi = nexti;
					nowj = nextj;
				} else {
					break; // 동작 멈춤
				}

			} else {
				d = d == 0 ? 3 : d - 1; // 90 도 회전
				int nexti = nowi + di[d];
				int nextj = nowj + dj[d];
				if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M && map[nexti][nextj] == 0) {
					nowi = nexti;
					nowj = nextj;
				}
			}
		}

		System.out.println(cleanCnt);
		sc.close();
	}

	static boolean remain(int nowi, int nowj) {
		for (int d = 0; d < di.length; d++) {
			int i = nowi + di[d];
			int j = nowj + dj[d];
			if (i >= 0 && i < N && j >= 0 && j < M && map[i][j] == 0) {
				return true;
			}
		}
		return false;
	}
}
