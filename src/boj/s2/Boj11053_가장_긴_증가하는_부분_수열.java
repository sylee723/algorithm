package boj.s2;

import java.util.Scanner;

public class Boj11053_가장_긴_증가하는_부분_수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] num = new int[N];

		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}

		int[] LIS = new int[N];
		for (int i = 0; i < N; i++) {
			LIS[i] = 1;
			for (int j = 0; j < i; j++) {
				if (num[i] > num[j]) {
					LIS[i] = Math.max(LIS[i], LIS[j] + 1);
				}
			}
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			answer = Math.max(answer, LIS[i]);
		}

		System.out.println(answer);
	}
}
