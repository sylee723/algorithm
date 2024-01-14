package boj.b3;

import java.util.Scanner;

public class Boj23971_ZOAC_4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int W = sc.nextInt();
		int N = sc.nextInt();
		int M = sc.nextInt();

		int row = H / (N + 1);
		if (H % (N + 1) != 0)
			row++;
		int col = W / (M + 1);
		if (W % (M + 1) != 0)
			col++;

		System.out.println(row * col);
	}
}
