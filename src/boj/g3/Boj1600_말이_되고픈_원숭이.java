package boj.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 해결 못함
public class Boj1600_말이_되고픈_원숭이 {
	static int K, W, H, answer;
	static int[][] map;
	static int[] di = { -1, 1, 0, 0, 2, 1, -1, -2, -2, -1, 1, 2 };
	static int[] dj = { 0, 0, -1, 1, 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end input

		answer = Integer.MAX_VALUE;
		bfs();
		if (answer == Integer.MAX_VALUE)
			answer = -1;
		System.out.println(answer);
	}

	private static void bfs() {
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(0, 0, 0, 0));
		boolean[][] visited = new boolean[H][W];
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			Point now = queue.poll();
			System.out.println(now);
			if (now.i == H - 1 && now.j == W - 1 && now.cnt2 <= K) {
				answer = Math.min(answer, now.cnt1 + now.cnt2);
			}
			if (now.cnt1 + now.cnt2 >= answer)
				continue;

			int nexti, nextj;
			for (int d = 0; d < di.length; d++) {
				nexti = now.i + di[d];
				nextj = now.j + dj[d];

				if (nexti >= 0 && nexti < H && nextj >= 0 && nextj < W && map[nexti][nextj] == 0
						&& !visited[nexti][nextj]) {
					if (d < 4)
						queue.add(new Point(nexti, nextj, now.cnt1 + 1, now.cnt2));
					else
						queue.add(new Point(nexti, nextj, now.cnt1, now.cnt2 + 1));
					visited[nexti][nextj] = true;
				}
			}
		}
	}

	static class Point {

		int i, j, cnt1, cnt2;

		public Point(int i, int j, int cnt1, int cnt2) {
			this.i = i;
			this.j = j;

			this.cnt1 = cnt1;
			this.cnt2 = cnt2;
		}

		@Override
		public String toString() {
			return "Point [i=" + i + ", j=" + j + ", cnt1=" + cnt1 + ", cnt2=" + cnt2 + "]";
		}
	}
}
