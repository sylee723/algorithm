package swea.d6;

import java.util.Scanner;

public class Swea1263_사람_네트워크2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt();
			int[][] graph = new int[N][N];
			int[][] D = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					graph[i][j] = sc.nextInt();
					D[i][j] = graph[i][j];
					if (i != j && graph[i][j] == 0) {
						D[i][j] = Integer.MAX_VALUE;
					}
				}
			}

			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					if (i == k)
						continue;
					for (int j = 0; j < N; j++) {
						if (k == j || i == j)
							continue;

						if (D[i][k] != Integer.MAX_VALUE && D[k][j] != Integer.MAX_VALUE) {
							D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
						}
					}
				}
			}

			int answer = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int CC = 0;
				for (int j = 0; j < N; j++) {
					CC += D[i][j];
				}
				answer = Math.min(answer, CC);
			}

			System.out.println("#" + tc + " " + answer);
		}
	}
}
