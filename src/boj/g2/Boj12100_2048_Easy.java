package boj.g2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Boj12100_2048_Easy {
	static int N, answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		int[][] board = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		answer = 0;
		bfs(board);
		System.out.println(answer);
	}

	private static void bfs(int[][] board) {
		Queue<int[][]> queue = new ArrayDeque<>();
		queue.add(board);

		int time = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			if (time > 5)
				return;
			
			for (int s = 0; s < size; s++) {
				int[][] now = queue.poll();
				
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						answer = Math.max(answer, now[i][j]);
					}
				}

				int[][] next;
				for (int d = 0; d < 4; d++) { // 상하좌우
					next = getNextBoard(now, d);
					if (next != null) {
						queue.add(next);
//						System.out.println(time + " // " + d);
//						printBoard(next);
					}
				}

			}
			time++;
		}

	}

	private static int[][] getNextBoard(int[][] now, int d) {
		int[][] next = new int[N][N];

		for (int x = 0; x < N; x++) {
			ArrayList<Integer> temp = new ArrayList<>();

			int i = 0, j = 0;
			for (int y = 0; y < N; y++) {
				switch (d) {
				case 0:
					i = y;
					j = x;
					break;
				case 1:
					i = N - y - 1;
					j = x;
					break;
				case 2:
					i = x;
					j = y;
					break;
				case 3:
					i = x;
					j = N - y - 1;
					break;
				}

				if (now[i][j] != 0)
					temp.add(now[i][j]);
			}

			for (int k = 0; k < temp.size() - 1; k++) {
				int A = temp.get(k);
				int B = temp.get(k+1);

				if (A==B) {
					temp.set(k, A * 2);
					temp.set(k + 1, 0);
				}
			}

			int idx = 0;
			for (int y = 0; y < N; y++) {
				if (idx < temp.size() && temp.get(idx) == 0)
					idx++;
				if (idx >= temp.size())
					break;
				switch (d) {
				case 0:
					i = y;
					j = x;
					break;
				case 1:
					i = N - y - 1;
					j = x;
					break;
				case 2:
					i = x;
					j = y;
					break;
				case 3:
					i = x;
					j = N - y - 1;
					break;
				}

				next[i][j] = temp.get(idx);
				idx++;
			}

		}

		boolean isSame = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (now[i][j] != next[i][j]) {
					isSame = false;
					break;
				}
			}
		}

		if (isSame)
			return null;
		else
			return next;
	}

//	private static void printBoard(int[][] board) {
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(board[i][j] + " ");
//			}
//			System.out.println();
//		}
//	}
}
