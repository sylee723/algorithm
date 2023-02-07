package boj.s3;

import java.util.Scanner;

//N과 M (1)
public class Boj15649 {
	static int N, M;
	static int[] result;
	static boolean[] used;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		result = new int[M];
		used = new boolean[N + 1];

		perm(0);
	}

	static void perm(int idx) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (used[i])
				continue;
			result[idx] = i;
			used[i] = true;
			perm(idx + 1);
			used[i] = false;
		}
	}
}
