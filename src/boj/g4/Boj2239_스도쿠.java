package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2239_스도쿠 {
	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[9][9];

		for (int i = 0; i < 9; i++) {
			String line = br.readLine();
			for (int j = 0; j < 9; j++) {
				board[i][j] = line.charAt(j) - '0';
			}
		}

		dfs(0);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	private static boolean dfs(int num) {
		if (num == 81) {
			return true;
		}

		int i = num / 9;
		int j = num % 9;

		boolean result = false;

		if (board[i][j] == 0) {
			for (int n = 1; n <= 9; n++) {
				board[i][j] = n;
				if (checkBoard(i, j, n)) {
					result = dfs(num + 1);
				}
				if (result)
					break;
				board[i][j] = 0;
			}
		} else {
			result = dfs(num + 1);
		}
		return result;
	}

	private static boolean checkBoard(int nowi, int nowj, int n) {
		// 행 체크
		for (int j = 0; j < 9; j++) {
			if (nowj != j && board[nowi][j] == n)
				return false;
		}

		// 열 체크
		for (int i = 0; i < 9; i++) {
			if (nowi != i && board[i][nowj] == n)
				return false;
		}

		// 3*3 체크
		int si = nowi / 3 * 3;
		int sj = nowj / 3 * 3;

		for (int i = si; i < si + 3; i++) {
			for (int j = sj; j < sj + 3; j++) {
				if (i == nowi && j == nowj)
					continue;
				if (board[i][j] == n)
					return false;
			}
		}

		return true;
	}
}
