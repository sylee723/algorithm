package boj.g5;

import java.util.Scanner;

public class Boj15989_1_2_3_더하기_4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int n = sc.nextInt();
			int answer = 0;

			for (int i = n; i >= 0; i -= 3) {
				answer += i / 2 + 1;
			}
			System.out.println(answer);
		}
	}
}
