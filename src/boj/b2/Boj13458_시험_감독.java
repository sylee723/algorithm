package boj.b2;

import java.util.Scanner;

public class Boj13458_시험_감독 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];

		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		int B = sc.nextInt();
		int C = sc.nextInt();

		long total_cnt = N;
		int cnt;
		for (int i = 0; i < N; i++) {
			int left_student = A[i] - B;
			if (left_student > 0) {
				cnt = left_student / C;
				if (left_student % C != 0)
					cnt++;
				total_cnt += cnt;
			}
		}

		System.out.println(total_cnt);
	}
}
