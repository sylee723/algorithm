package boj.g4;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj14002_가장_긴_증가하는_부분_수열_4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int[][] LIS = new int[N][2];
		int max = 0;
		int idx = 0;

		for (int i = 0; i < N; i++) {
			LIS[i][0] = 1;
			LIS[i][1] = i;

			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && LIS[i][0] < LIS[j][0] + 1) {
					LIS[i][0] = LIS[j][0] + 1;
					LIS[i][1] = j;
				}
			}

			if (max < LIS[i][0]) {
				max = LIS[i][0];
				idx = i;
			}
		}

		ArrayList<Integer> result = new ArrayList<>();
		while (true) {
			result.add(arr[idx]);

			if (idx == LIS[idx][1]) {
				break;
			}
			idx = LIS[idx][1];
		}

		System.out.println(max);
		for (int i = result.size() - 1; i >= 0; i--) {
			System.out.print(result.get(i) + " ");
		}
	}
}
