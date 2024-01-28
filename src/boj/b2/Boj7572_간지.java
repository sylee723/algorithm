package boj.b2;

import java.util.Scanner;

public class Boj7572_간지 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		String gan = "0123456789";
		String ji = "ABCDEFGHIJKL";

		System.out.print(ji.charAt((N + 8) % 12));
		System.out.print(gan.charAt((N + 6) % 10));
	}
}
