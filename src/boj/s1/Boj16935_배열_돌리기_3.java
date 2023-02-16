package boj.s1;

import java.util.Scanner;

public class Boj16935_배열_돌리기_3 {
	static int N, M;
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		int R = sc.nextInt();
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int[] op = new int[R];
		for (int i = 0; i < R; i++) {
			op[i] = sc.nextInt();
		}

		print();
		System.out.println("###################");
		arr = upDown();
		print();
		System.out.println("###################");
		arr = rotate();
		print();
	}

	static int[][] upDown() {
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[N - 1 - i][j];
				arr[N - 1 - i][j] = temp;
			}
		}
		return arr;
	}
	
	static int[][] rotate() {
		int[][] rotatedArr = new int[M][N];
		for (int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				rotatedArr[i][j] = arr[N - i][j];
			}
		}
		return rotatedArr;
	}

	static void print() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
