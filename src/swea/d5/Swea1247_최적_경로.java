package swea.d5;

import java.util.Scanner;

public class Swea1247_최적_경로 {

	static int N, si, sj, ei, ej, minDistance;
	static int[] result;
	static boolean[] used;
	static int[][] customer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();

			si = sc.nextInt();
			sj = sc.nextInt();
			ei = sc.nextInt();
			ej = sc.nextInt();

			customer = new int[N][2];
			for (int i = 0; i < N; i++) {
				customer[i][0] = sc.nextInt();
				customer[i][1] = sc.nextInt();
			}
			result = new int[N];
			used = new boolean[N];
			minDistance = Integer.MAX_VALUE;
			perm(0);
			System.out.println("#" + tc + " " + minDistance);
		}
	}

	static void perm(int idx) {
		if (idx == N) {
			int distance = 0;
			int x1 = si;
			int y1 = sj;
			int x2, y2;
			for (int i = 0; i < N; i++) {
				x2 = customer[result[i]][0];
				y2 = customer[result[i]][1];
				distance += Math.abs(x1 - x2) + Math.abs(y1 - y2);
				x1 = x2;
				y1 = y2;
			}
			x2 = ei;
			y2 = ej;
			distance += Math.abs(x1 - x2) + Math.abs(y1 - y2);
			
			minDistance = Math.min(minDistance, distance);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (used[i])
				continue;
			used[i] = true;
			result[idx] = i;
			perm(idx + 1);
			used[i] = false;
		}
	}
}
