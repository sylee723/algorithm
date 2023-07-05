package swea.d3;

import java.util.Scanner;

public class Swea10726_이진수_표현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			boolean result = true;
			for (int n = 0; n < N; n++) {
				int check = M % 2;
				if (check == 0) {
					result = false;
					break;
				}
				M /= 2;
			}
			String answer;
			if (result)
				answer = "ON";
			else
				answer = "OFF";
			System.out.println("#" + tc + " " + answer);
		}
	}
}
