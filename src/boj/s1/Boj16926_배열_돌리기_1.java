package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16926_배열_돌리기_1 {
	static int[][] A, result;
	static int R;
	static int[] di = { 1, 0, -1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		A = new int[N][M];
		result = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end input

		rotateArr(A, 0, N - 1, 0, M - 1);
		printArr(result);
	}

	static void rotateArr(int[][] A, int top_i, int bottom_i, int left_j, int right_j) {

		if (top_i >= bottom_i || left_j >= right_j)
			return;

		for (int i = top_i; i <= bottom_i; i++) {
			for (int j = left_j; j <= right_j; j++) {
				if (i != top_i && i != bottom_i && j != left_j && j != right_j)
					continue;
				int ri = i;
				int rj = j;
				int d = 0;
				int r = R;
				if (i >= top_i && i < bottom_i && j == left_j) {
					d = 0;
				} else if (j >= left_j && j < right_j && i == bottom_i) {
					d = 1;
				} else if (i > top_i && i <= bottom_i && j == right_j) {
					d = 2;
				} else if (j > left_j && j <= right_j && i == top_i) {
					d = 3;
				}
				while (r > 0) {
					ri += di[d];
					rj += dj[d];
					r--;
					if ((ri == top_i && rj == left_j) || (ri == top_i && rj == right_j)
							|| (ri == bottom_i && rj == left_j) || (ri == bottom_i && rj == right_j)) {
						d = (d + 1) % 4;
					}
				}
				result[ri][rj] = A[i][j];
			}
		}
		rotateArr(A, top_i + 1, bottom_i - 1, left_j + 1, right_j - 1);
	}

	static void printArr(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
