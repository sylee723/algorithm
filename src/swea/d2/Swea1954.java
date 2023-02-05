package swea.d2;

import java.util.Scanner;

// 달팽이 숫자
public class Swea1954 {
	public static int[][] board;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		int[] di = { 0, 1, 0, -1 };
		int[] dj = { 1, 0, -1, 0 };

		for (int tc = 1; tc <= TC; tc++) {
			int n = sc.nextInt();
			board = new int[n][n];
			int num = 1;
			int i = 0;
			int j = 0;
			int d = 0;
			while (true) {
				if (num > n * n)
					break;
				if (i >= 0 && i < n && j >= 0 && j < n) {
					board[i][j] = num;
					num++;
				}
				int nexti = i + di[d];
				int nextj = j + dj[d];
				if (nexti == n || nextj == n || nexti == -1 || nextj == -1 || board[nexti][nextj] != 0) {
					d++;
					d = d % 4;

					nexti = i + di[d];
					nextj = j + dj[d];
				}
				i = nexti;
				j = nextj;
			}

			System.out.println("#" + tc);
			for (int x = 0; x < n; x++) {
				for (int y = 0; y < n; y++) {
					System.out.print(board[x][y] + " ");
				}
				System.out.println();
			}
		}
	}
}
