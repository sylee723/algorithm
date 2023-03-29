package boj.g5;

import java.util.Arrays;
import java.util.Scanner;

// 해결 못함
public class Boj2293_동전_1 {
	static int N, K, count;
	static int[] coin;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();

		coin = new int[N];
		for (int i = 0; i < N; i++) {
			coin[i] = sc.nextInt();
		}

		int[] D = new int[K + 1];
		for (int m = 0; m <= K; m++) {
			for (int i = 0; i < N; i++) {
				if (m > coin[i]) {
					D[m] += D[m - coin[i]];
				} else if (m == coin[i]) {
					D[m] += 1;
				}
			}
		}
		System.out.println(Arrays.toString(D));
	}
}
