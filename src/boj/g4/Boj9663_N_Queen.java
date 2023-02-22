package boj.g4;

import java.util.Scanner;

public class Boj9663_N_Queen {
	static int N, col[], answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		col = new int[N + 1];
		answer = 0;
		
		setQueen(1);
		System.out.println(answer);
		sc.close();
	}

	static void setQueen(int rowNo) {
		if (rowNo == N + 1) {
			answer++;
			return;
		}
		for (int c = 1; c <= N; c++) {
			if (rowNo == 1 || isAvailable(rowNo, c)) { // 첫째 행은 조건 검사 안해도 됨
				col[rowNo] = c;
				setQueen(rowNo + 1);
			}

		}
	}

	static boolean isAvailable(int rowNo, int checkCol) {
		for (int r = 1; r < rowNo; r++) {
			if (col[r] == checkCol || Math.abs(rowNo - r) == Math.abs(checkCol - col[r])) {
				return false;
			}
		}
		return true;
	}
}
