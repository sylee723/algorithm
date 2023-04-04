package boj.g4;

import java.util.Scanner;

public class Boj15961_회전_초밥 {
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

		int[] selected = new int[d + 1];
		selected[c] = 1; // 쿠폰 사용
		int count = 1;
		int max_count = 0;
		int start = 0;
		int end = k % N;

		for (int i = start; i < end; i++) {
			if (selected[belt[i]] == 0) {
				count++;
			}
			selected[belt[i]]++;
		}

		max_count = Math.max(max_count, count);
		while (start < N) {
			if (--selected[belt[start]] == 0) {
				count--;
			}
			if (++selected[belt[end]] == 1) {
				count++;
			}
			max_count = Math.max(max_count, count);
			start++;
			end = (end + 1) % N;
		}

		System.out.println(max_count);
	}
}
