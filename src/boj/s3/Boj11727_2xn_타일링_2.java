package boj.s3;

import java.util.Scanner;

public class Boj11727_2xn_타일링_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] memo = new int[n + 1];
		memo[0] = 1;
		memo[1] = 1;

		for (int i = 2; i <= n; i++) {
			memo[i] = memo[i - 1] + 2 * memo[i - 2];
			memo[i] %= 10007;
		}

		System.out.println(memo[n]);
	}
}
