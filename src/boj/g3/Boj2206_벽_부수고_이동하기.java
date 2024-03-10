package boj.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2206_벽_부수고_이동하기 {
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		int answer = bfs(map, N, M);
		System.out.println(answer);
	}

	private static int bfs(char[][] map, int N, int M) {
		Queue<Point> queue = new ArrayDeque<>();
		boolean[][][] visited = new boolean[N][M][2];

		visited[0][0][0] = true;
		queue.add(new Point(0, 0, 1, 0));

		while (!queue.isEmpty()) {
			Point now = queue.poll();
			if (now.i == N - 1 && now.j == M - 1) {
				return now.count;
			}

			for (int d = 0; d < 4; d++) {
				int nexti = now.i + di[d];
				int nextj = now.j + dj[d];

				if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= M) {
					continue;
				}

				if (map[nexti][nextj] == '0' && !visited[nexti][nextj][now.isBroken]) {
					visited[nexti][nextj][now.isBroken] = true;
					queue.add(new Point(nexti, nextj, now.count + 1, now.isBroken));
				} else if (map[nexti][nextj] == '1' && now.isBroken == 0 && !visited[nexti][nextj][1]) {
					visited[nexti][nextj][1] = true;
					queue.add(new Point(nexti, nextj, now.count + 1, 1));
				}
			}
		}

		return -1;
	}

	static class Point {
		int i, j, count, isBroken;

		public Point(int i, int j, int count, int isBroken) {
			this.i = i;
			this.j = j;
			this.count = count;
			this.isBroken = isBroken; // 0 : 벽 안 부수고 방문, 1: 벽 부수고 방문
		}
	}
}
