package boj.g4;

import java.util.Scanner;

public class Boj17406_배열_돌리기_4 {
	static int N, M, K, minVal;
	static int[] result;
	static boolean[] used;
	static int[][] origin, arr, rotate_info;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		origin = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				origin[i][j] = sc.nextInt();
			}
		}
		rotate_info = new int[K][3];
		for (int i = 0; i < K; i++) {
			rotate_info[i][0] = sc.nextInt() - 1;
			rotate_info[i][1] = sc.nextInt() - 1;
			rotate_info[i][2] = sc.nextInt();
		}

		result = new int[K];
		used = new boolean[K];
		arr = new int[N][M];
		minVal = Integer.MAX_VALUE;
		perm(0);
		System.out.println(minVal);
	}

	static int getValue(int[][] A) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < A.length; i++) {
			int temp = 0;
			for (int j = 0; j < A[i].length; j++) {
				temp += A[i][j];
			}
			min = Math.min(min, temp);
		}
		return min;
	}

	static void rotate(int[][] A, int r, int c, int S) {
		for (int s = 1; s <= S; s++) {
			int temp = A[r - s][c - s];
			for (int i = r - s; i < r + s; i++) {
				A[i][c - s] = A[i + 1][c - s];
			}
			for (int j = c - s; j < c + s; j++) {
				A[r + s][j] = A[r + s][j + 1];
			}
			for (int i = r + s; i > r - s; i--) {
				A[i][c + s] = A[i - 1][c + s];
			}
			for (int j = c + s; j > c - s + 1; j--) {
				A[r - s][j] = A[r - s][j - 1];
			}
			A[r - s][c - s + 1] = temp;
		}
	}

	static void perm(int idx) {
		if (idx == K) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[i][j] = origin[i][j]; // 원본 배열 복사
				}
			}
			for (int k = 0; k < K; k++)
				rotate(arr, rotate_info[result[k]][0], rotate_info[result[k]][1], rotate_info[result[k]][2]);

			minVal = Math.min(minVal, getValue(arr));
			return;
		}

		for (int i = 0; i < K; i++) {
			if (used[i])
				continue;
			result[idx] = i;
			used[i] = true;
			perm(idx + 1);
			used[i] = false;
		}
	}
}
