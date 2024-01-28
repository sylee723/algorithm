package boj.s3;

import java.util.Arrays;
import java.util.Scanner;

public class Boj15657_N과_M_8 {
	static int N, M;
	static int[] num, result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		Arrays.sort(num);
		result = new int[M];
		comb(0, 0);

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

		for (int i = start; i < N; i++) {
			result[idx] = num[i];
			comb(idx + 1, i);
		}
	}
}
