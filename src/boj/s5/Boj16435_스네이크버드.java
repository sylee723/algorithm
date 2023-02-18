package boj.s5;

import java.util.Arrays;
import java.util.Scanner;

public class Boj16435_스네이크버드 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int L = sc.nextInt();

		int[] h = new int[N];
		for (int i = 0; i < N; i++) {
			h[i] = sc.nextInt();
		}
		Arrays.sort(h);

		int idx = 0;
		while (idx < N && L >= h[idx]) {
			L++;
			idx++;
		}
		System.out.println(L);
	}
}
