package boj.g5;

import java.util.Scanner;

public class Boj12865_평범한_배낭_re {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] weights = new int[N + 1];
		int[] values = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			weights[i] = sc.nextInt();
			values[i] = sc.nextInt();
		}

		int[][] D = new int[N + 1][K + 1];
		for (int i = 1; i <= N; i++) {
			for (int w = 1; w <= K; w++) {
				if (weights[i] > w) {
					D[i][w] = D[i - 1][w];
				} else {
					D[i][w] = Math.max(D[i - 1][w], D[i - 1][w - weights[i]] + values[i]);
				}
			}
		}
		System.out.println(D[N][K]);
	}
}
