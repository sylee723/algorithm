package swea.d2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea1974 {
	public static boolean check_row(int[][] board) {
		for (int i = 0; i < 9; i++) {
			boolean[] check = new boolean[10];
			for (int j = 0; j < 9; j++) {
				int num = board[i][j];
				if (!check[num]) // 겹치지 않은 숫자이면
					check[num] = true;
				else
					return false;
			}
		}
		return true;
	}

	public static boolean check_col(int[][] board) {
		for (int j = 0; j < 9; j++) {
			boolean[] check = new boolean[10];
			for (int i = 0; i < 9; i++) {
				int num = board[i][j];
				if (!check[num]) // 겹치지 않은 숫자이면
					check[num] = true;
				else
					return false;
			}
		}
		return true;
	}

	public static boolean check_3by3(int[][] board) {
		for (int si = 0; si <= 6; si += 3) {
			for (int sj = 0; sj <= 6; sj += 3) {
				boolean[] check = new boolean[10];
				for (int i = si; i < si + 3; i++) {
					for (int j = sj; j < sj + 3; j++) {
						int num = board[i][j];
						if (!check[num]) // 겹치지 않은 숫자이면
							check[num] = true;
						else
							return false;
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int[][] board = new int[9][9];
			for (int i = 0; i < 9; i++) {
				String[] line = br.readLine().split(" ");
				for (int j = 0; j < 9; j++) {
					board[i][j] = Integer.parseInt(line[j]);
				}
			}

			int result = 0;
			if (check_row(board) && check_col(board) && check_3by3(board))
				result = 1;

			System.out.println("#" + test_case + " " + result);
		}
	}
}
