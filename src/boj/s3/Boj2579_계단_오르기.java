package boj.s3;

import java.util.Scanner;

public class Boj2579_계단_오르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] stair = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			stair[i] = sc.nextInt();
		}

		int[][] dp = new int[N + 1][2];
		dp[1][0] = stair[1];
		dp[1][1] = stair[1];

		for (int i = 2; i <= N; i++) {
			dp[i][0] = dp[i - 1][1] + stair[i];
			dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + stair[i];
		}

		System.out.println(Math.max(dp[N][0], dp[N][1]));
	}
}
