package boj.s4;

import java.util.Scanner;

public class Boj1205_등수_구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int score = sc.nextInt();
		int P = sc.nextInt();

		int[] ranking = new int[N];
		for (int i = 0; i < N; i++) {
			ranking[i] = sc.nextInt();
		}

		int rank = 1;
		boolean update = (N + 1 <= P) ? true : false;
		for (int i = 0; i < N; i++) {
			if (score < ranking[i]) {
				rank++;
			} else if (score > ranking[i]) {
				update = true;
				break;
			}
		}

		if (!update) {
			rank = -1;
		}

		System.out.println(rank);
	}
}
