package boj.g5;

import java.util.Scanner;

// 플로이드 워샬
public class Boj9205_맥주_마시면서_걸어가기 {
	static int N;
	static int[][] D;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			N = sc.nextInt();
			int[][] points = new int[N + 2][2];
			for (int i = 0; i < N + 2; i++) {
				points[i][0] = sc.nextInt();
				points[i][1] = sc.nextInt();
			}

			D = new int[N + 2][N + 2];
			for (int i = 0; i < N + 2; i++) {
				for (int j = 0; j < N + 2; j++) {
					if (i == j)
						continue;
					int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
					if (dist <= 1000)
						D[i][j] = 1;
					else
						D[i][j] = 102; // max value
				}
			}

			for (int k = 0; k < N + 2; k++) {
				for (int i = 0; i < N + 2; i++) {
					if (i == k)
						continue;
					for (int j = 0; j < N + 2; j++) {
						if (k == j || i == j)
							continue;
						D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
					}
				}
			}

//			for (int i = 0; i < N + 2; i++) {
//				for (int j = 0; j < N + 2; j++) {
//					System.out.print(D[i][j] + " ");
//				}
//				System.out.println();
//			}

			if (D[0][N + 1] <= 101)
				System.out.println("happy");
			else
				System.out.println("sad");
		}
	}
}
