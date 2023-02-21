package boj.g5;

import java.util.Arrays;

public class Boj6987_월드컵 {
	static int[][] result;
	static boolean[] selected;
	static int[] winlose;

	public static void main(String[] args) {
		result = new int[6][3];
		int cnt = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = i + 1; j < 6; j++) {
				cnt++;
			}
		}
		System.out.println(cnt);
		selected = new boolean[6];
		winlose = new int[15];
//		comb(0, 0);
		perm(0);
	}

	static void comb(int idx, int cnt) {
		if (cnt == 2) {
			System.out.println(Arrays.toString(selected));
			return;
		}
		if (idx == 6) return;

		
		selected[idx] = true;
		comb(idx + 1, cnt+1);

		selected[idx] = false;
		comb(idx + 1, cnt);

		
	}
	static void perm(int idx) {
		if (idx == 15) {
			System.out.println(Arrays.toString(winlose));
			
			for (int i = 0; i < 6; i++) {
				for (int j = i + 1; j < 6; j++) {
				}
			}
			return;
		}
		winlose[idx] = -1;
		perm(idx+1);
		winlose[idx] = 0;
		perm(idx+1);
		winlose[idx] = 1;
		perm(idx+1);
	}
}
