package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1987_알파벳 {
	static int R, C, count;
	static char[][] board;
	static boolean[] used;
	static boolean[][] visited;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new char[R][];
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}

		used = new boolean[26]; // 사용된 알파벳인지 체크
		visited = new boolean[R][C];

		bfs(0, 0);

		System.out.println(count);
//		for(int i = 0; i<used.length;i++) {
//			if(used[i]) {
//				System.out.print((char)(i + 'A') + " ");
//			}
//		}
	}

	private static void bfs(int si, int sj) {
		Queue<Point> queue = new LinkedList<>();
		visited[si][sj] = true;
		used[board[si][sj] - 'A'] = true;
		queue.add(new Point(si, sj));

		count = 0;
		while (!queue.isEmpty()) {
			Point now = queue.poll();
			count++;

			for (int d = 0; d < 4; d++) {
				int nexti = now.i + di[d];
				int nextj = now.j + dj[d];

				if (nexti >= 0 && nexti < R && nextj >= 0 && nextj < C && !visited[nexti][nextj]
						&& !used[board[nexti][nextj] - 'A']) {
					visited[nexti][nextj] = true;
					used[board[nexti][nextj] - 'A'] = true;
					queue.add(new Point(nexti, nextj));
				}
			}
		}
	}

	static class Point {
		int i;
		int j;

		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}
}
