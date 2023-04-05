package boj.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Boj1941_소문난_칠공주 {
	static int answer;
	static char[][] map;
	static boolean[][] selected;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][];
		for (int i = 0; i < 5; i++) {
			map[i] = br.readLine().toCharArray();
		}

		answer = 0;
		selected = new boolean[5][5];
		comb(0, 0, 0);
		System.out.println(answer);
	}

	private static void comb(int num, int cnt, int sCnt) {
		if (cnt - sCnt >= 4)
			return;
		if (cnt == 7) {
			if (checkPoints()) { // 칠공주 인접해 있는지 확인
				answer++;
//				for (int i = 0; i < 5; i++) {
//					for (int j = 0; j < 5; j++) {
//						System.out.print(selected[i][j] ? map[i][j] : ".");
//					}
//					System.out.println();
//				}
//				System.out.println("###############################");
			}
			return;
		}
		if (num == 25)
			return;

		int i = num / 5;
		int j = num % 5;

		selected[i][j] = true;
		if (map[i][j] == 'S') {
			comb(num + 1, cnt + 1, sCnt + 1);
		} else {
			comb(num + 1, cnt + 1, sCnt);
		}

		selected[i][j] = false;
		comb(num + 1, cnt, sCnt);

	}

	private static boolean checkPoints() {
		Queue<Point> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[5][5];
		boolean flag = false;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (selected[i][j]) {
					queue.add(new Point(i, j));
					visited[i][j] = true;
					flag = true;
					break;
				}
			}
			if (flag)
				break;
		}

		int count = 0;
		int nexti, nextj;
		while (!queue.isEmpty()) {
			Point now = queue.poll();
			count++;
			for (int d = 0; d < 4; d++) {
				nexti = now.i + di[d];
				nextj = now.j + dj[d];
				if (nexti >= 0 && nexti < 5 && nextj >= 0 && nextj < 5 && !visited[nexti][nextj]
						&& selected[nexti][nextj]) {
					queue.add(new Point(nexti, nextj));
					visited[nexti][nextj] = true;
				}
			}
		}
		if (count == 7)
			return true;
		else
			return false;
	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
