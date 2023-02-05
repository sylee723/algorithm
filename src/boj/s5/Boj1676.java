package boj.s5;

import java.util.Scanner;

//팩토리얼 0의 개수
public class Boj1676 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int fiveCount = 0;

		for (int i = 1; i <= n; i++) {
			int num = i;
			while (num % 5 == 0) {
				fiveCount++;
				num /= 5;
			}
		}
		System.out.println(fiveCount);
	}
}
