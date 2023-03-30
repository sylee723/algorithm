package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 시간 초과
public class Boj2239_스도쿠 {
	static boolean done;
	static int[][] board;
	static int[] number;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[9][9];
		number = new int[10];

		for (int i = 1; i < 10; i++) {
			number[i] = 9;
		}
		for (int i = 0; i < 9; i++) {
			String line = br.readLine();
			for (int j = 0; j < 9; j++) {
				board[i][j] = line.charAt(j) - '0';
				number[board[i][j]]--;
			}
		}

		done = false;
		sudoku(0);
	}

	private static void sudoku(int num) {
		if (done)
			return;
		if (num == 81) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(board[i][j]);
				}
				System.out.println();
			}

			done = true;
			return;
		}
		int i = num / 9;
		int j = num % 9;

		if (board[i][j] == 0) {
			for (int x = 1; x < 10; x++) {
				if (number[x] > 0) {
					number[x]--;
					board[i][j] = x;
					if (checkBoard())
						sudoku(num + 1);
					number[x]++;
					board[i][j] = 0;
				}
			}
		} else {
			sudoku(num + 1);
		}
	}

	private static boolean checkBoard() {
		boolean[] check;
		// 행 체크
		for (int i = 0; i < 9; i++) {
			check = new boolean[10];
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != 0 && check[board[i][j]])
					return false;
				check[board[i][j]] = true;
			}
		}

		// 열 체크
		for (int j = 0; j < 9; j++) {
			check = new boolean[10];
			for (int i = 0; i < 9; i++) {
				if (board[i][j] != 0 && check[board[i][j]])
					return false;
				check[board[i][j]] = true;
			}
		}

		// 3*3 체크
		for (int si = 0; si < 9; si += 3) {
			for (int sj = 0; sj < 9; sj += 3) {
				check = new boolean[10];
				for (int i = si; i < si + 3; i++) {
					for (int j = sj; j < sj + 3; j++) {
						if (board[i][j] != 0 && check[board[i][j]])
							return false;
						check[board[i][j]] = true;
					}
				}
			}
		}

		return true;
	}
}
