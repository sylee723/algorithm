package boj.b2;

import java.util.Scanner;

// 틀렸습니다
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

		int count = 0;
		for (int i = 0; i < N; i++) {
			count++; // 총 감독관 한명
			if (A[i] - B > 0) { // 부 감독관
				count += (A[i] - B) / C;
				if ((A[i] - B) % C != 0)
					count++;
			}
		}
		System.out.println(count);
	}
}
