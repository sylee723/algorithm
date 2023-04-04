package boj.s1;

import java.util.Scanner;

// 고지식한 패턴 매칭
public class Boj2531_회전_초밥 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int d = sc.nextInt();
		int k = sc.nextInt();
		int c = sc.nextInt();

		int[] belt = new int[N];
		for (int i = 0; i < N; i++) {
			belt[i] = sc.nextInt();
		}

		boolean[] selected;
		int max_count = 0;

		for (int i = 0; i < N; i++) {
			selected = new boolean[d + 1];
			int count = 0;
			for (int j = i; j < i + k; j++) {
				int idx = j % N;
				if (!selected[belt[idx]]) {
					selected[belt[idx]] = true;
					count++;
				}
			}

			if (!selected[c])
				count++;
			max_count = Math.max(max_count, count);
		}

		System.out.println(max_count);
	}
}
