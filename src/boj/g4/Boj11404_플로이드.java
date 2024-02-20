package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11404_플로이드 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[][] cost = new int[N + 1][N + 1];
		StringTokenizer st;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) {
					cost[i][j] = 0;
				} else {
					cost[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			cost[a][b] = Math.min(cost[a][b], c);
		}

		for (int k = 1; k <= N; k++) {
			for (int s = 1; s <= N; s++) {
				for (int e = 1; e <= N; e++) {
					if (s == e || s == k || k == e)
						continue;

					if (cost[s][k] != Integer.MAX_VALUE && cost[k][e] != Integer.MAX_VALUE
							&& cost[s][e] > cost[s][k] + cost[k][e]) {
						cost[s][e] = cost[s][k] + cost[k][e];
					}
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (cost[i][j] == Integer.MAX_VALUE) {
					System.out.print(0 + " ");
				} else {
					System.out.print(cost[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
}
