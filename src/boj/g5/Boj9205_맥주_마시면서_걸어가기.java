package boj.g5;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

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
					D[i][j] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
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

			if (bfs())
				System.out.println("happy");
			else
				System.out.println("sad");
		}
	}

	private static boolean bfs() {
		boolean[] visited = new boolean[N + 2]; // 0은 집, N+1은 페스티벌 장소
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(0);
		visited[0] = true;

		while (!queue.isEmpty()) {
			int now = queue.poll();
			if (now == N + 1)
				return true;
			for (int j = 0; j < N + 2; j++) {
				if (D[now][j] <= 1000 && !visited[j]) {
					queue.add(j);
					visited[j] = true;
				}
			}
		}

		return false;
	}
}
