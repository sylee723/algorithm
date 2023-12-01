package boj.s1;

import java.util.Scanner;

public class Boj6064_카잉_달력 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int M, N, x, y;
		for (int t = 0; t < T; t++) {
			M = sc.nextInt();
			N = sc.nextInt();
			x = sc.nextInt();
			y = sc.nextInt();

			int answer = -1;
			for (int k = x; k <= M * N; k += M) {
				if (k - y >= 0 && (k - y) % N == 0) {
					answer = k;
					break;
				}
			}

			System.out.println(answer);
		}
	}

}
