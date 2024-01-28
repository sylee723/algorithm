package boj.s1;

import java.util.Scanner;

public class Boj1629_곱셈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		long answer = power(A, B, C);
		System.out.println(answer);
	}

	private static long power(int a, int b, int c) {
		if (b == 0)
			return 1;

		long division = power(a, b / 2, c);
		if (b % 2 == 0) {
			return (division * division) % c;
		} else {
			return (((division * division) % c) * (a % c)) % c;
		}
	}
}
