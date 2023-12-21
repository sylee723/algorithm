package boj.g1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1194_달이_차오른다_가자 {
	static int N, M;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];
		Point start = null;

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == '0') {
					start = new Point(i, j, 0);
					map[i][j] = '.';
				}
			}
		}

		int answer = bfs(start, map);
		System.out.println(answer);
	}

	private static int bfs(Point start, char[][] map) {
		Queue<Point> queue = new ArrayDeque<>();
		boolean[][][] visited = new boolean[N][M][64];

		visited[start.i][start.j][start.key] = true;
		queue.add(start);

		int count = 0;
		int size;
		while (!queue.isEmpty()) {
			size = queue.size();

			for (int s = 0; s < size; s++) {
				Point now = queue.poll();
				if (map[now.i][now.j] == '1') {
					return count;
				}

				for (int d = 0; d < 4; d++) {
					int nexti = now.i + di[d];
					int nextj = now.j + dj[d];

					if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= M || map[nexti][nextj] == '#')
						continue;

					if (map[nexti][nextj] == '.' || map[nexti][nextj] == '1') {
						if (!visited[nexti][nextj][now.key]) {
							visited[nexti][nextj][now.key] = true;
							queue.add(new Point(nexti, nextj, now.key));
						}
					} else if (map[nexti][nextj] >= 'a' && map[nexti][nextj] <= 'f') {
						// 열쇠를 집는다
						int nextKey = now.key | (1 << (map[nexti][nextj] - 'a'));
						if (!visited[nexti][nextj][nextKey]) {
							visited[nexti][nextj][nextKey] = true;
							queue.add(new Point(nexti, nextj, nextKey));
						}
					} else if (map[nexti][nextj] >= 'A' && map[nexti][nextj] <= 'F') {
						if (!visited[nexti][nextj][now.key] && (now.key & (1 << (map[nexti][nextj] - 'A'))) > 0) {
							visited[nexti][nextj][now.key] = true;
							queue.add(new Point(nexti, nextj, now.key));
						}
					}
				}
			}
			count++;
		}

		return -1;
	}

	static class Point {
		int i, j, key;

		public Point(int i, int j, int key) {
			this.i = i;
			this.j = j;
			this.key = key;
		}
	}
}
