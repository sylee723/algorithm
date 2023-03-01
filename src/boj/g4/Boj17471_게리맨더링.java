package boj.g4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj17471_게리맨더링 {
	static int N, minDiff;
	static int[] peopleNum;
	static boolean[] selected;
	static int[][] adjMatrix;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		peopleNum = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			peopleNum[i] = sc.nextInt();
		}

		adjMatrix = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			int num = sc.nextInt();
			for (int n = 0; n < num; n++) {
				int j = sc.nextInt();
				adjMatrix[i][j] = 1;
			}
		}

		selected = new boolean[N + 1];
		minDiff = Integer.MAX_VALUE;
		subset(1, 0);

		if (minDiff == Integer.MAX_VALUE)
			minDiff = -1;
		System.out.println(minDiff);
	}

	private static void subset(int idx, int cnt) {
		if (idx == N + 1) {
			if (cnt == N || cnt == 0)
				return;

			if (isAvailable()) {
				int pcount1 = 0;
				int pcount2 = 0;
				for (int i = 1; i <= N; i++) {
					if (selected[i]) {
						pcount1 += peopleNum[i];
					} else {
						pcount2 += peopleNum[i];
					}
				}

				minDiff = Math.min(minDiff, Math.abs(pcount1 - pcount2));
			}

			return;
		}

		selected[idx] = true;
		subset(idx + 1, cnt + 1);
		selected[idx] = false;
		subset(idx + 1, cnt);
	}

	private static boolean isAvailable() {
		boolean[] check1 = new boolean[N + 1];
		boolean[] check2 = new boolean[N + 1];
		Queue<Integer> queue1 = new LinkedList<>();
		Queue<Integer> queue2 = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (selected[i]) {
				queue1.add(i);
				check1[i] = true;
				break;
			}
		}

		while (!queue1.isEmpty()) {
			int now = queue1.poll();
			for (int j = 1; j <= N; j++) {
				if (adjMatrix[now][j] == 1 && selected[j] && !check1[j]) {
					check1[j] = true;
					queue1.add(j);
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			if (!selected[i]) {
				queue2.add(i);
				check2[i] = true;
				break;
			}
		}

		while (!queue2.isEmpty()) {
			int now = queue2.poll();
			for (int j = 1; j <= N; j++) {
				if (adjMatrix[now][j] == 1 && !selected[j] && !check2[j]) {
					check2[j] = true;
					queue2.add(j);
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			if ((selected[i] && check1[i]) || (!selected[i] && check2[i]))
				continue;
			return false;
		}
		return true;
	}
}
