package boj.b3;

import java.util.Arrays;
import java.util.Scanner;

public class Boj5073_삼각형과_세_변 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] triangle = new int[3];
		StringBuilder sb = new StringBuilder();

		while (true) {
			triangle[0] = sc.nextInt();
			triangle[1] = sc.nextInt();
			triangle[2] = sc.nextInt();

			if (triangle[0] == 0 && triangle[1] == 0 && triangle[2] == 0) {
				break;
			}
			Arrays.sort(triangle);

			if (triangle[2] >= triangle[0] + triangle[1]) {
				sb.append("Invalid\n");
			} else {
				if (triangle[0] == triangle[1] && triangle[1] == triangle[2]) {
					sb.append("Equilateral\n");
				} else if (triangle[0] == triangle[1] || triangle[1] == triangle[2]) {
					sb.append("Isosceles\n");
				} else {
					sb.append("Scalene\n");
				}
			}
		}

		System.out.println(sb.toString());
	}
}
