package boj.g2;

import java.util.Scanner;

public class Boj17822_원판_돌리기 {
	static int N, M;
	static int[] topIdx;
	static Num[][] board;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		int T = sc.nextInt();
		board = new Num[N + 1][M + 1];
		topIdx = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				board[i][j] = new Num(0, sc.nextInt());
			}
			topIdx[i] = 1;
		}

		for (int t = 0; t < T; t++) {
			int x = sc.nextInt();
			int d = sc.nextInt();
			int k = sc.nextInt();

			rotate(x, d, k);
			remove();
		}

		int answer = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (board[i][j].status == 0) {
					answer += board[i][j].value;
				}
			}
		}

		System.out.println(answer);
	}

	private static void rotate(int x, int d, int k) {
		for (int i = x; i <= N; i += x) {
			int top = topIdx[i];
			if (d == 0) { // 시계 방향
				top += (M - k);
			} else { // 반시계 방향
				top += k;
			}

			if (top > M) {
				top -= M;
			}

			topIdx[i] = top;
		}
	}

	private static void remove() {
		boolean removeYn = false;

		// 같은 원판 내에서 인접한 수 확인
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				int next;
				if (j == M) {
					next = 1;
				} else {
					next = j + 1;
				}
				if (board[i][j].status != 2 && board[i][next].status != 2
						&& board[i][j].value == board[i][next].value) {
					removeYn = true;
					board[i][j].status = 1;
					board[i][next].status = 1;
				}
			}
		}

		// 다른 원판 인접한 수 확인
		for (int i = 1; i < N; i++) {
			int now = topIdx[i];
			int next = topIdx[i + 1];
			for (int n = 0; n < M; n++) {
				if (board[i][now].status != 2 && board[i + 1][next].status != 2
						&& board[i][now].value == board[i + 1][next].value) {
					removeYn = true;
					board[i][now].status = 1;
					board[i + 1][next].status = 1;
				}
				now++;
				next++;

				if (now == M + 1) {
					now = 1;
				}
				if (next == M + 1) {
					next = 1;
				}
			}
		}

		if (removeYn) { // 지울 수가 있는 경우
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if (board[i][j].status == 1) {
						board[i][j].status = 2;
					}
				}
			}
		} else { // 지울 수가 없는 경우
			float total = 0;
			int count = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if (board[i][j].status == 0) {
						total += board[i][j].value;
						count++;
					}
				}
			}

			float avg = total / count;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if (board[i][j].status == 0) {
						if (board[i][j].value > avg) {
							board[i][j].value--;
						} else if (board[i][j].value < avg) {
							board[i][j].value++;
						}
					}
				}
			}
		}
	}

	static class Num {
		int status; // 0 : 안 지워짐 1: 이번 턴에 지워짐 2: 지워짐
		int value;

		public Num(int status, int value) {
			super();
			this.status = status;
			this.value = value;
		}
	}
}
