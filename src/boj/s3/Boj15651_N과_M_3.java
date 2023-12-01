package boj.s3;

import java.util.Scanner;

public class Boj15651_N과_M_3 {
	static int N, M;
	static int[] result;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		result = new int[M];
		sb = new StringBuilder();
		perm(0);

		System.out.println(sb.toString());
	}

	private static void perm(int idx) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int n = 1; n <= N; n++) {
			result[idx] = n;
			perm(idx + 1);
		}
	}
}
