package boj.s3;

import java.util.Scanner;

public class Boj17626_Four_Squares {
	static int n, answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		answer = 4;

		dfs(0, 0);
		System.out.println(answer);
	}

	private static void dfs(int sum, int count) {
		if (sum == n) {
			answer = Math.min(count, answer);
			return;
		}

		if (count >= 3)
			return;

		for (int i = 1; i * i <= n - sum; i++) {
			dfs(sum + i * i, count + 1);
		}
	}
}
