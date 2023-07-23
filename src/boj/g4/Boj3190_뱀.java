package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj3190_뱀 {
	static int[] di = { 0, -1, 0, 1, 0 }; // 위부터 시계방향
	static int[] dj = { 0, 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N + 1][N + 1];
		int[][] snake = new int[N + 1][N + 1];

		int K = Integer.parseInt(br.readLine());
		for (int k = 0; k < K; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int ai = Integer.parseInt(st.nextToken());
			int aj = Integer.parseInt(st.nextToken());

			board[ai][aj] = 1;
		}

		int L = Integer.parseInt(br.readLine());
		Map<Integer, Character> changeDir = new HashMap<Integer, Character>();
		for (int l = 0; l < L; l++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);

			changeDir.put(time, dir);
		}

		int time = 1;
		int nowd = 2; // 오른쪽
		int hi = 1;
		int hj = 1;
		int ti = 1;
		int tj = 1;

		int next_hi, next_hj;

		while (true) {
			snake[hi][hj] = nowd;
//			System.out.println(time - 1);
//			for (int i = 1; i <= N; i++) {
//				for (int j = 1; j <= N; j++) {
//					if (board[i][j] == 1)
//						System.out.print("# ");
//					else
//						System.out.print(snake[i][j] + " ");
//				}
//				System.out.println();
//			}

			next_hi = hi + di[nowd];
			next_hj = hj + dj[nowd];

			if (next_hi < 1 || next_hi > N || next_hj < 1 || next_hj > N || snake[next_hi][next_hj] > 0)
				break;

			if (board[next_hi][next_hj] == 1) { // 사과가 있으면
				board[next_hi][next_hj] = 0;
			} else { // 꼬리 위치한 칸 비우기
				int tDir = snake[ti][tj];
				snake[ti][tj] = 0;
				ti = ti + di[tDir];
				tj = tj + dj[tDir];
			}

			hi = next_hi;
			hj = next_hj;

			if (changeDir.containsKey(time)) {
				nowd = setDir(nowd, changeDir.get(time));
			}

			time++;
		}
		System.out.println(time);
	}

	private static int setDir(int dir, char turn) {
		int result = 0;
		if (turn == 'L') {
			if (dir == 1)
				result = 4;
			else
				result = dir - 1;
		} else {
			if (dir == 4)
				result = 1;
			else
				result = dir + 1;
		}
		return result;
	}
}
