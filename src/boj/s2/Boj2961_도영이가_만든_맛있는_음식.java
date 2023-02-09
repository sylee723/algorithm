package boj.s2;

import java.util.Scanner;

public class Boj2961_도영이가_만든_맛있는_음식 {
	static int N;
	static int[][] input;
	static boolean[] selected;
	static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		input = new int[N][2];
		selected = new boolean[N];
		for (int n = 0; n < N; n++) {
			input[n][0] = sc.nextInt();
			input[n][1] = sc.nextInt();
		}

		answer = Integer.MAX_VALUE;
		subset(0, 0);
		System.out.println(answer);
	}

	static void subset(int idx, int cnt) {
		if (idx == N) {
			if (cnt == 0)
				return;
			int S = 1;
			int B = 0;
			for (int i = 0; i < N; i++) {
				if (selected[i]) {
					S *= input[i][0];
					B += input[i][1];
				}
			}
			answer = Math.min(answer, Math.abs(S - B));
			return;
		}

		selected[idx] = true;
		subset(idx + 1, cnt + 1);
		selected[idx] = false;
		subset(idx + 1, cnt);
	}
}
