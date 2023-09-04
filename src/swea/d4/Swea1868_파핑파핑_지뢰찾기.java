package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Swea1868_파핑파핑_지뢰찾기 {
	static int N, answer;
	static char[][] board;
	static boolean[][] visited;
	static int[] di = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dj = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			board = new char[N][N];

			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++) {
					board[i][j] = line.charAt(j);
				}
			}

			answer = 0;
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					boolean isStartPoint = true;

					for (int d = 0; d < 8; d++) {
						int ni = i + di[d];
						int nj = j + dj[d];

						if (ni < 0 || ni >= N || nj < 0 || nj >= N)
							continue;

						if (board[ni][nj] == '*') {
							isStartPoint = false;
							break;
						}
					}

					if (isStartPoint) {
						if (board[i][j] == '.' && !visited[i][j]) {
							answer++;
							dfs(new Point(i, j));
						}
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] == '.' && !visited[i][j])
						answer++;
				}
			}

			System.out.println("#" + tc + " " + answer);
		}
	}

	private static void dfs(Point now) {
		visited[now.i][now.j] = true;

		boolean isPop = false;
		ArrayList<Point> nextPoint = new ArrayList<>();

		for (int d = 0; d < 8; d++) {
			int nexti = now.i + di[d];
			int nextj = now.j + dj[d];

			if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= N)
				continue;

			if (board[nexti][nextj] == '*') {
				isPop = true;
				break;
			}

			nextPoint.add(new Point(nexti, nextj));
		}

		if (isPop)
			return;

		for (int p = 0; p < nextPoint.size(); p++) {
			Point next = nextPoint.get(p);

			if (!visited[next.i][next.j])
				dfs(next);
		}
	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}
}
