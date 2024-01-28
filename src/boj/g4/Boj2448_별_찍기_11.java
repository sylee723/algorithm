package boj.g4;

import java.util.Scanner;

public class Boj2448_별_찍기_11 {
	static boolean[][] board;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		board = new boolean[N + 1][2 * N];

		triangle(N, 1, N, 2 * N);

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < board.length; i++) {
			for (int j = 1; j < board[0].length; j++) {
				if (board[i][j]) {
					sb.append('*');
				} else {
					sb.append(' ');
				}
			}
			sb.append('\n');
		}

		System.out.println(sb.toString());
	}

	private static void triangle(int si, int sj, int h, int w) {
		if (h == 3) {
			for (int j = sj; j < sj + 5; j++) {
				board[si][j] = true;
			}
			board[si - 1][sj + 1] = true;
			board[si - 1][sj + 3] = true;
			board[si - 2][sj + 2] = true;

			return;
		}

		triangle(si, sj, h / 2, w / 2);
		triangle(si - h / 2, sj + w / 4, h / 2, w / 2);
		triangle(si, sj + w / 2, h / 2, w / 2);
	}

}
