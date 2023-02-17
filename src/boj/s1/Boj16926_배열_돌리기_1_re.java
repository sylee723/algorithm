package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16926_배열_돌리기_1_re {
	static int N, M;
	static int[][] A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int r = 0; r < R; r++) {
			rotate();
		}
		printArr();
	}

	static void rotate() {
		for (int d = 0; d < Math.min(N, M) / 2; d++) {
			int start = A[d][d];
			for (int j = d + 1; j < M - d; j++) {
				A[d][j - 1] = A[d][j];
			}
			for (int i = d + 1; i < N - d; i++) {
				A[i - 1][M - 1 - d] = A[i][M - 1 - d];
			}
			for (int j = M - 2 - d; j >= d; j--) {
				A[N - 1 - d][j + 1] = A[N - 1 - d][j];
			}
			for (int i = N - 2 - d; i >= d + 1; i--) {
				A[i + 1][d] = A[i][d];
			}
			A[d + 1][d] = start;
		}

	}

	static void printArr() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
	}
}
