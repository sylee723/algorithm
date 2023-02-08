package boj.s3;

import java.util.Scanner;

//N과 M (2)
public class Boj15650_조합_부분집합버전 {
	static int N, M;
	static boolean[] selected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		selected = new boolean[N];

		comb(0, 0);
	}

	static void comb(int idx, int cnt) {
		if (cnt == M) {
			for (int i = 0; i < N; i++) {
				if (selected[i])
					System.out.print(i+1 + " ");
			}
			System.out.println();
			return;
		}
		
		if (idx == N)
			return;
		
		selected[idx] = true;
		comb(idx+1, cnt+1);
		selected[idx] = false;
		comb(idx+1, cnt);
	}
}
