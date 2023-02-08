package boj.s3;

import java.util.Scanner;

//N과 M (2)
public class Boj15650 {
	static int N, M;
	static int[] result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		result = new int[M];

		comb(0, 1);
	}

	static void comb(int idx, int start) {
		if (idx == M) {
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i <= N; i++) {
			result[idx] = i;
			comb(idx + 1, i + 1);
		}
	}
}
