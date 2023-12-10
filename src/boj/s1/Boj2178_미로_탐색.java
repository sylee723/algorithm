package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2178_미로_탐색 {
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];

		String line;
		for (int i = 0; i < N; i++) {
			line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		int answer = bfs(map);
		System.out.println(answer);
	}

	private static int bfs(char[][] map) {
		int N = map.length;
		int M = map[0].length;

		boolean[][] visit = new boolean[N][M];
		Queue<Point> queue = new ArrayDeque<>();

		queue.add(new Point(0, 0));
		visit[0][0] = true;

		int size;
		int count = 1;
		while (!queue.isEmpty()) {
			size = queue.size();
			for (int s = 0; s < size; s++) {
				Point now = queue.poll();
				if (now.i == N - 1 && now.j == M - 1) {
					return count;
				}

				for (int d = 0; d < 4; d++) {
					int nexti = now.i + di[d];
					int nextj = now.j + dj[d];

					if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= M)
						continue;

					if (!visit[nexti][nextj] && map[nexti][nextj] == '1') {
						visit[nexti][nextj] = true;
						queue.add(new Point(nexti, nextj));
					}
				}
			}
			count++;
		}
		return -1;
	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
