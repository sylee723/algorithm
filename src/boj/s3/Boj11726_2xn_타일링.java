package boj.s3;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Boj11726_2xn_타일링 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int n = sc.nextInt();
		int[] memo = new int[n + 1];
		memo[0] = 1;
		memo[1] = 1;

		for (int i = 2; i <= n; i++) {
			memo[i] = (memo[i - 1] + memo[i - 2]) % 10007;
		}

		System.out.println(memo[n]);
	}
}
