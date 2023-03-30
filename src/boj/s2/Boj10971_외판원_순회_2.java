package boj.s2;

import java.util.Scanner;

public class Boj10971_외판원_순회_2 {
	static int N, answer;
	static int[][] cost;
	static int[] result;
	static boolean[] selected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cost = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cost[i][j] = sc.nextInt();
			}
		}

		result = new int[N];
		selected = new boolean[N];
		answer = Integer.MAX_VALUE;
		perm(0);
		System.out.println(answer);
	}

	private static void perm(int idx) {
		if (idx == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (i == N - 1) {
					if (cost[result[i]][result[0]] == 0)
						return;
					sum += cost[result[i]][result[0]];
				} else {
					if (cost[result[i]][result[i + 1]] == 0)
						return;
					sum += cost[result[i]][result[i + 1]];
				}
			}
			answer = Math.min(answer, sum);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (selected[i])
				continue;
			result[idx] = i;
			selected[i] = true;
			perm(idx + 1);
			selected[i] = false;
		}
	}
}
