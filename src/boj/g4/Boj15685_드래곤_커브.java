package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15685_드래곤_커브 {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int sx, sy, ex, ey, cx, cy;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		boolean[][] board = new boolean[101][101];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());

			boolean[][] dragon = new boolean[101][101];

			sx = x; // 시작점
			sy = y;
			ex = x + dx[d]; // 끝점
			ey = y + dy[d];

			dragon[sy][sx] = true;
			dragon[ey][ex] = true;

			for (int g = 1; g <= G; g++) {
				turnDragon(dragon);

				ey = sy;
				ex = sx;
				sx = x;
				sy = y;
//				printBoard(dragon);
			}

			for (int i = 0; i <= 100; i++) {
				for (int j = 0; j <= 100; j++) {
					if (dragon[i][j])
						board[i][j] = true;
				}
			}
		}

		System.out.println(checkSquare(board));
	}

	private static void turnDragon(boolean[][] dragon) {
		boolean[][] curve = new boolean[101][101];
		boolean isMoved = false;

		curve[ey][ex] = dragon[ey][ex];

		// 1사분면을 4사분면으로
		for (int i = 1; ey - i >= 0; i++) {
			for (int j = 0; ex + j <= 100; j++) {
				if (ey + j > 100 || ex + i > 100)
					continue;

				curve[ey + j][ex + i] = dragon[ey - i][ex + j];
				if (!isMoved && sy == ey - i && sx == ex + j) {
					sy = ey + j;
					sx = ex + i;
					isMoved = true;
				}
			}
		}

		// 4사분면을 3사분면으로
		for (int i = 1; ex + i <= 100; i++) {
			for (int j = 0; ey + j <= 100; j++) {
				if (ey + i > 100 || ex - j < 0)
					continue;

				curve[ey + i][ex - j] = dragon[ey + j][ex + i];
				if (!isMoved && sy == ey + j && sx == ex + i) {
					sy = ey + i;
					sx = ex - j;
					isMoved = true;
				}
			}
		}

		// 3사분면을 2사분면으로
		for (int i = 1; ey + i <= 100; i++) {
			for (int j = 0; ex - j >= 0; j++) {
				if (ey - j < 0 || ex - i < 0)
					continue;

				curve[ey - j][ex - i] = dragon[ey + i][ex - j];
				if (!isMoved && sy == ey + i && sx == ex - j) {
					sy = ey - j;
					sx = ex - i;
					isMoved = true;
				}
			}
		}

		// 2사분면을 1사분면으로
		for (int i = 1; ex - i >= 0; i++) {
			for (int j = 0; ey - j >= 0; j++) {
				if (ey - i < 0 || ex + j > 100)
					continue;

				curve[ey - i][ex + j] = dragon[ey - j][ex - i];
				if (!isMoved && sy == ey - j && sx == ex - i) {
					sy = ey - i;
					sx = ex + j;
					isMoved = true;
				}
			}
		}

		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				if (curve[i][j]) {
					dragon[i][j] = true;
				}
			}
		}

	}

	private static int checkSquare(boolean[][] board) {
		int count = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (board[i][j] && board[i + 1][j] && board[i][j + 1] && board[i + 1][j + 1])
					count++;
			}
		}
		return count;
	}

//	private static void printBoard(boolean[][] board) {
//		for (int y = 0; y <= 10; y++) {
//			for (int x = 0; x <= 10; x++) {
//				System.out.print(board[y][x] ? "#" : ".");
//			}
//			System.out.println();
//		}
//	}
}
