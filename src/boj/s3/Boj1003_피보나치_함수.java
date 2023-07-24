package boj.s3;

import java.util.Scanner;

public class Boj1003_피보나치_함수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		int[][] memo = new int[41][2];

		memo[0][0] = 1;
		memo[0][1] = 0;
		memo[1][0] = 0;
		memo[1][1] = 1;

		for (int i = 2; i <= 40; i++) {
			memo[i][0] = memo[i - 1][0] + memo[i - 2][0];
			memo[i][1] = memo[i - 1][1] + memo[i - 2][1];
		}

		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			System.out.println(memo[N][0] + " " + memo[N][1]);
		}
	}
}
