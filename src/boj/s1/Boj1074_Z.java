package boj.s1;

import java.util.Scanner;

public class Boj1074_Z {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		int result = 0;
		while (true) {
			int area = findArea(N, r, c);
			result += Math.pow(2, 2 * (N - 1)) * area;

			if (N == 1) {
				break;
			}

			N = N - 1;
			switch (area) {
			case 0:
				break;
			case 1:
				c -= Math.pow(2, N);
				break;
			case 2:
				r -= Math.pow(2, N);
				break;
			case 3:
				c -= Math.pow(2, N);
				r -= Math.pow(2, N);
				break;
			}
		}

		System.out.println(result);
		sc.close();
	}

	static int findArea(int N, int r, int c) {
		if (r >= 0 && r < Math.pow(2, N - 1)) {
			if (c >= 0 && c < Math.pow(2, N - 1))
				return 0;
			else
				return 1;
		} else {
			if (c >= 0 && c < Math.pow(2, N - 1))
				return 2;
			else
				return 3;
		}
	}
}
