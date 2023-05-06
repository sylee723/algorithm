package boj.s3;

import java.util.Scanner;

public class Boj14501_퇴사 {
	static int N, answer;
	static int[][] consulting;
	static boolean[] selected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		consulting = new int[N][2];
		for (int i = 0; i < N; i++) {
			consulting[i][0] = sc.nextInt();
			consulting[i][1] = sc.nextInt();
		}

		selected = new boolean[N];
		answer = -1;
		subset(0);
		System.out.println(answer);
	}

	private static void subset(int idx) {
		if (idx >= N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (selected[i]) {
					sum += consulting[i][1];
				}
			}
			answer = Math.max(answer, sum);
			return;
		}

		if (idx + consulting[idx][0] <= N) {
			selected[idx] = true;
			subset(idx + consulting[idx][0]);
		}
		selected[idx] = false;
		subset(idx + 1);
	}
}
