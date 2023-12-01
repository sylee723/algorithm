package boj.g3;

import java.util.Scanner;

public class Boj17779_게리맨더링_2 {
	static int N, answer;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		answer = Integer.MAX_VALUE;
		for (int d1 = 1; d1 <= N - 2; d1++) {
			for (int d2 = 1; d2 <= N - 2; d2++) {
				for (int x = 0; x + d1 + d2 < N; x++) {
					for (int y = d1; y + d2 < N; y++) {
						separate(x, y, d1, d2);
					}
				}
			}
		}
		System.out.println(answer);
	}

	private static void separate(int x, int y, int d1, int d2) {
		int[] count = new int[6];

		int left = y;
		int right = y;
		int l_value = 1;
		int r_value = 2;
		int dd1 = 0;
		int dd2 = 0;
		for (int i = 0; i < N; i++) {
			if (i < x) {
				for (int j = 0; j <= y; j++) {
					count[1] += map[i][j];
				}
				for (int j = y + 1; j < N; j++) {
					count[2] += map[i][j];
				}
			} else if (i > x + d1 + d2) {
				for (int j = 0; j < y - d1 + d2; j++) {
					count[3] += map[i][j];
				}
				for (int j = y - d1 + d2; j < N; j++) {
					count[4] += map[i][j];
				}
			} else {
				for (int j = 0; j < N; j++) {
					if (j < left) {
						count[l_value] += map[i][j];
					} else if (j >= left && j <= right) {
						count[5] += map[i][j];
					} else {
						count[r_value] += map[i][j];
					}
				}
				if (dd1 < d1) {
					left--;
					dd1++;
				} else {
					left++;
				}
				if (dd1 == d1) {
					l_value = 3;
				}

				if (dd2 < d2) {
					right++;
					dd2++;
				} else {
					right--;
					r_value = 4;
				}
			}
		}

		int max = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= 5; i++) {
			max = Math.max(max, count[i]);
			min = Math.min(min, count[i]);
		}

		answer = Math.min(answer, max - min);
	}
}
