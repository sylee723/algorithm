package boj.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15684_사다리_조작 {
	static int N, H, answer;
	static boolean[][] ladder;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		ladder = new boolean[H + 1][N];

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ladder[a][b] = true;
		}

		answer = 4;

		for (int g = 0; g <= 3; g++) {
			dfs(0, g);
			if (answer == g)
				break;
		}

		if (answer == 4)
			answer = -1;

		System.out.println(answer);
	}

	private static void dfs(int cnt, int goal) {
		if (cnt == goal) {
			if (game()) {
				answer = Math.min(answer, cnt);
			}
			return;
		}

		for (int r = 1; r <= H; r++) {
			for (int c = 1; c < N; c++) {
				if (!ladder[r][c] && !(c > 1 && ladder[r][c - 1]) && !(c < N - 1 && ladder[r][c + 1])) {
					ladder[r][c] = true;
					dfs(cnt + 1, goal);
					ladder[r][c] = false;
				}
			}
		}
	}

	private static boolean game() {
		for (int x = 1; x <= N; x++) {
			int nowi = 0;
			int nowj = x;
			while (true) {
				nowi++;
				if (nowi > H)
					break;

				if (nowj < N && ladder[nowi][nowj]) {
					nowj++;
				} else if (nowj > 1 && ladder[nowi][nowj - 1]) {
					nowj--;
				}
			}

			if (nowj != x) {
				return false;
			}
		}
		return true;
	}
}
