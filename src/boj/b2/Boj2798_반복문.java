package boj.b2;

import java.util.Scanner;

//블랙잭
public class Boj2798_반복문 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] cards = new int[n];
		
		for (int i = 0; i < n; i++) {
			cards[i] = sc.nextInt();
		}

		int max = 0;
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					int sum = cards[i] + cards[j] + cards[k];
					if (sum <= m && sum > max)
						max = sum;
				}
			}
		}
		System.out.println(max);
	}
}
