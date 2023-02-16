package swea.d3;

import java.util.Scanner;

public class Swea5215_햄버거_다이어트 {
	static boolean[] selected;
	static int N, L;
	static Ingredient[] input;
	static int bestScore;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			L = sc.nextInt();

			input = new Ingredient[N];
			for (int n = 0; n < N; n++) {
				input[n] = new Ingredient(sc.nextInt(), sc.nextInt());
			}

			selected = new boolean[N];
			bestScore = Integer.MIN_VALUE;
			subset(0);

			System.out.println("#" + tc + " " + bestScore);
		}
	}

	static class Ingredient {
		int score;
		int calory;

		public Ingredient(int score, int calory) {
			this.score = score;
			this.calory = calory;
		}
	}

	static void subset(int idx) {
		if (idx == N) {
			int s_sum = 0;
			int c_sum = 0;
			for (int i = 0; i < N; i++) {
				if (selected[i]) {
					s_sum += input[i].score;
					c_sum += input[i].calory;
				}
			}
			if (c_sum <= L) {
				bestScore = Math.max(s_sum, bestScore);
			}
			return;
		}
		selected[idx] = true;
		subset(idx + 1);
		selected[idx] = false;
		subset(idx + 1);
	}
}
