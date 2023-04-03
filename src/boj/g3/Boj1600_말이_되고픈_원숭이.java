package boj.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1600_말이_되고픈_원숭이 {
	static int K, W, H;
	static int[][] map;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static int[] sdi = { 2, 1, -1, -2, -2, -1, 1, 2 };
	static int[] sdj = { 1, 2, 2, 1, -1, -2, -2, -1 };

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

		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(0, 0, 0));
		boolean[][][] visited = new boolean[H][W][K + 1];
		visited[0][0][0] = true;

		int time = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Point now = queue.poll();

				if (now.i == H - 1 && now.j == W - 1)
					return time;
				int nexti, nextj, nexts;
				for (int d = 0; d < 4; d++) { // 인접한 방향으로 움직임
					nexti = now.i + di[d];
					nextj = now.j + dj[d];
					nexts = now.skill;
					if (nexti >= 0 && nexti < H && nextj >= 0 && nextj < W && map[nexti][nextj] == 0
							&& !visited[nexti][nextj][nexts]) {
						visited[nexti][nextj][nexts] = true;
						queue.add(new Point(nexti, nextj, nexts));
					}
				}

				for (int d = 0; d < 8; d++) { // 말처럼 움직임
					nexti = now.i + sdi[d];
					nextj = now.j + sdj[d];
					nexts = now.skill + 1;
					if (nexti >= 0 && nexti < H && nextj >= 0 && nextj < W && nexts <= K && map[nexti][nextj] == 0
							&& !visited[nexti][nextj][nexts]) {
						visited[nexti][nextj][nexts] = true;
						queue.add(new Point(nexti, nextj, nexts));
					}
				}
			}
			time++;

		}
		return -1;
	}

	static class Point {

		int i, j, skill;

		public Point(int i, int j, int skill) {
			super();
			this.i = i;
			this.j = j;
			this.skill = skill;
		}
	}
}
