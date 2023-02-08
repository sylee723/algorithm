package boj.b2;

import java.util.Scanner;

//블랙잭
public class Boj2798_재귀 {
	public static int n, m;
	public static int[] cards;
	public static int[] result;
	public static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		cards = new int[n];
		result = new int[3];
		for (int i = 0; i < n; i++) {
			cards[i] = sc.nextInt();
		}
		chooseCard(0, 0);
		System.out.println(max);
	}

	public static void chooseCard(int cnt, int start) { // 조합
		if (cnt == 3) {
			int sum = 0;
			for (int i = 0; i < 3; i++)
				sum += result[i];
			if (sum <= m && sum >= max) {
				max = sum;
			}
			return;
		}
		for (int i = start; i < n; i++) {
			result[cnt] = cards[i];
			chooseCard(cnt + 1, i + 1);
		}
	}
}
