package boj.s2;

import java.util.Scanner;

public class Boj15663_N과_M_9 {
	static int N, M;
	static int[] num, selected, result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		num = new int[10001];

		for (int i = 0; i < N; i++) {
			num[sc.nextInt()]++;
		}

		selected = new int[10001];
		result = new int[M];
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

		for (int i = 1; i < num.length; i++) {
			if (selected[i] < num[i]) {
				selected[i]++;
				result[idx] = i;
				perm(idx + 1);
				selected[i]--;
			}
		}
	}
}
