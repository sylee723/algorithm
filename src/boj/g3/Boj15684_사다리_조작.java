package boj.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 초과
public class Boj15684_사다리_조작 {
	static int N, H, goal, answer;
	static boolean[] selected;
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

		answer = -1;
		selected = new boolean[(N - 1) * H];

		for (int g = 0; g <= 3; g++) {
			goal = g;
			subset(0, 0);
			if (answer == g)
				break;
		}

		System.out.println(answer);
	}

	private static void subset(int idx, int cnt) {
		if (cnt == goal) {
			boolean[][] copyLadder = new boolean[H + 1][N];
			copy(copyLadder);

			for (int i = 0; i < (N - 1) * H; i++) {
				if (selected[i]) {
					int r = i / (N - 1) + 1;
					int c = i % (N - 1) + 1;

					// 두 가로선 연속하는 경우
					if ((c > 1 && copyLadder[r][c - 1]) || (c < N - 1 && copyLadder[r][c + 1]))
						return;

					copyLadder[r][c] = true;
				}
			}

			game(copyLadder, cnt);
			return;
		}

		if (cnt > goal || idx == (N - 1) * H)
			return;

		int r = idx / (N - 1) + 1;
		int c = idx % (N - 1) + 1;

		if (!ladder[r][c]) {
			selected[idx] = true;
			subset(idx + 1, cnt + 1);
			selected[idx] = false;
		}
		subset(idx + 1, cnt);
	}

	private static void game(boolean[][] copyLadder, int cnt) {
		boolean available = true;

//		printLadder(copyLadder);

		for (int x = 1; x <= N; x++) {
			int nowi = 0;
			int nowj = x;
			while (true) {
				nowi++;
				if (nowi > H)
					break;

				if (nowj < N && copyLadder[nowi][nowj]) {
					nowj++;
				} else if (nowj > 1 && copyLadder[nowi][nowj - 1]) {
					nowj--;
				}
			}

			if (nowj != x) {
				available = false;
				break;
			}
		}

		if (available) {
			answer = cnt;
		}
	}

	private static void copy(boolean[][] copyLadder) {
		for (int i = 1; i < ladder.length; i++) {
			for (int j = 1; j < ladder[0].length; j++) {
				copyLadder[i][j] = ladder[i][j];
			}
		}
	}

	private static void printLadder(boolean[][] ladder) {
		for (int i = 1; i < ladder.length; i++) {
			System.out.print("#");
			for (int j = 1; j < ladder[0].length; j++) {
				if (ladder[i][j])
					System.out.print("##");
				else
					System.out.print(" #");
			}
			System.out.println();
		}
		System.out.println();
	}
}
