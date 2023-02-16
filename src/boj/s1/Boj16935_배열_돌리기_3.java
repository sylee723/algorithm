package boj.s1;

import java.util.Scanner;

public class Boj16935_배열_돌리기_3 {
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt();
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for (int r = 0; r < R; r++) {
			int op = sc.nextInt();
			switch (op) {
			case 1:
				arr = upDown();
				break;
			case 2:
				arr = rotate();
				arr = upDown();
				arr = rotate();
				arr = rotate();
				arr = rotate();
				break;
			case 3:
				arr = rotate();
				break;
			case 4:
				arr = rotate();
				arr = rotate();
				arr = rotate();
				break;
			case 5:
				arr = move();
				break;
			case 6:
				arr = move();
				arr = move();
				arr = move();
				break;
			}
		}

		print();
	}

	static int[][] upDown() {
		int N = arr.length;
		int M = arr[0].length;
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j <M; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[N - 1 - i][j];
				arr[N - 1 - i][j] = temp;
			}
		}
		return arr;
	}

	static int[][] rotate() {
		int N = arr.length;
		int M = arr[0].length;
		int[][] rotatedArr = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				rotatedArr[j][N - 1 - i] = arr[i][j];
			}
		}
		return rotatedArr;
	}

	static int[][] move() {
		int N = arr.length;
		int M = arr[0].length;
		int[][] movedArr = new int[N][M];
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				movedArr[i][j + M / 2] = arr[i][j];
			}
		}
		for (int i = 0; i < N / 2; i++) {
			for (int j = M / 2; j < M; j++) {
				movedArr[i + N / 2][j] = arr[i][j];
			}
		}
		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				movedArr[i - N / 2][j] = arr[i][j];
			}
		}
		for (int i = N / 2; i < N; i++) {
			for (int j = M / 2; j < M; j++) {
				movedArr[i][j - M / 2] = arr[i][j];
			}
		}
		return movedArr;
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
