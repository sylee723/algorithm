package boj.s2;

import java.util.Scanner;

//색종이 만들기
public class Boj2630 {
	static int[][] board;
	static int[] count_paper = new int[2];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		board = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		// 색종이 자르기 전에 전체 종이 확인
		if (check_color(0, 0, n)) {
			count_paper[board[0][0]]++;
		} else {
			cut_paper(0, 0, n);
		}

		System.out.println(count_paper[0]);
		System.out.println(count_paper[1]);
	}

	static void cut_paper(int si, int sj, int n) {
		for (int i = si; i < si + n; i += n / 2) {
			for (int j = sj; j < sj + n; j += n / 2) {
				if (check_color(i, j, n / 2)) {
					count_paper[board[i][j]]++;
				} else {
					cut_paper(i, j, n / 2);
				}
			}
		}
	}

	static boolean check_color(int si, int sj, int n) {
		int color = board[si][sj];
		for (int i = si; i < si + n; i++) {
			for (int j = sj; j < sj + n; j++) {
				if (board[i][j] != color)
					return false;
			}
		}
		return true;
	}
}
