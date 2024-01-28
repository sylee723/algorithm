package boj.s3;

import java.util.Arrays;
import java.util.Scanner;

public class Boj15654_N과_M_5 {
	static int N, M;
	static int[] num, result;
	static boolean[] selected;
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
		selected = new boolean[N];
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

		for (int i = 0; i < N; i++) {
			if (!selected[i]) {
				result[idx] = num[i];
				selected[i] = true;
				perm(idx + 1);
				selected[i] = false;
			}
		}
	}
}
