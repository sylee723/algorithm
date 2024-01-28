package boj.s3;

import java.util.Scanner;

public class Boj15652_N과_M_4 {
	static int N, M;
	static StringBuilder sb;
	static int[] result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		sb = new StringBuilder();
		result = new int[M];
		comb(0, 1);

		System.out.println(sb.toString());
	}

	private static void comb(int idx, int start) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i <= N; i++) {
			result[idx] = i;
			comb(idx + 1, i);
		}
	}
}
