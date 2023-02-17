package swea.d2;

import java.util.Scanner;

public class Swea1954_달팽이_숫자_re {
	static int[] di = { 0, 1, 0, -1 };
	static int[] dj = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();

			int[][] board = new int[N][N];
			int num = 1;
			int i = 0;
			int j = 0;
			int d = 0;
			while (true) {
				if (num > N * N)
					break;
				board[i][j] = num;
				int nexti = i + di[d];
				int nextj = j + dj[d];

				if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= N || board[nexti][nextj] != 0) {
					d = (d + 1) % 4;
					nexti = i + di[d];
					nextj = j + dj[d];
				}
				i = nexti;
				j = nextj;
				num++;
			}

			System.out.println("#" + t);
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					System.out.print(board[r][c] + " ");
				}
				System.out.println();
			}
		}
	}
}
