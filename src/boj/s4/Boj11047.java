package boj.s4;

import java.util.Scanner;

//동전 0
public class Boj11047 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] coin = new int[N];

		for (int i = 0; i < N; i++) {
			coin[i] = sc.nextInt();
		}

		int count = 0;
		int money = K;
		while (money != 0) {
			for (int i = N - 1; i >= 0; i--) {
				if (money / coin[i] > 0) {
					count += money / coin[i];
					money %= coin[i];
					break;
				}
			}
		}
		System.out.println(count);
	}
}
