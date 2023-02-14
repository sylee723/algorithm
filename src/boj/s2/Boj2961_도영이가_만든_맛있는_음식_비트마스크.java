package boj.s2;

import java.util.Scanner;

public class Boj2961_도영이가_만든_맛있는_음식_비트마스크 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] input = new int[N][2];

		for (int i = 0; i < N; i++) {
			input[i][0] = sc.nextInt();
			input[i][1] = sc.nextInt();
		}
		int answer = Integer.MAX_VALUE;
		for (int i = 1; i < Math.pow(2, N); i++) {
			int sour = 1;
			int bitter = 0;
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) != 0) {
					sour *= input[j][0];
					bitter += input[j][1];
				}
			}
			int diff = Math.abs(sour - bitter);
			answer = Math.min(answer, diff);
		}

		System.out.println(answer);
		sc.close();
	}
}
