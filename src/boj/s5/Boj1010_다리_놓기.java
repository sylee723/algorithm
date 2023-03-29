package boj.s5;

import java.util.Scanner;

public class Boj1010_다리_놓기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] comb = new int[30][30];

		for (int i = 1; i < 30; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || i == j) {
					comb[i][j] = 1;
				} else {
					comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j];
				}
			}
		}

		int N, M;
		for (int t = 0; t < T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();

			System.out.println(comb[M][N]);
		}
	}
}
