package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj3055_탈출 {
	static int R, C;
	static char[][] map;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static Queue<Point> water;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][];
		int nowi = -1, nowj = -1;
		water = new ArrayDeque<>();
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'S') {
					nowi = i;
					nowj = j;
					map[i][j] = '.';
				} else if (map[i][j] == '*') {
					water.add(new Point(i, j));
				}
			}
		}
		int answer = bfs(nowi, nowj);
		System.out.println(answer == -1 ? "KAKTUS" : answer);
	}

	private static int bfs(int nowi, int nowj) {
		Queue<Point> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[R][C];
		visited[nowi][nowj] = true;

		queue.add(new Point(nowi, nowj));
		int time = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			// 이동 전에 물이 참
			moveWater();
			// 이동
			for (int s = 0; s < size; s++) {
				Point now = queue.poll();
				if (map[now.i][now.j] == 'D') {
					return time;
				}
				for (int d = 0; d < 4; d++) {
					int nexti = now.i + di[d];
					int nextj = now.j + dj[d];

					if (nexti >= 0 && nexti < R && nextj >= 0 && nextj < C && !visited[nexti][nextj]
							&& map[nexti][nextj] != '*' && map[nexti][nextj] != 'X') {
						queue.add(new Point(nexti, nextj));
						visited[nexti][nextj] = true;
					}
				}
			}
			time++;
		}

		return -1;
	}

	private static void moveWater() {
		int size = water.size();
		for (int i = 0; i < size; i++) {
			Point now = water.poll();
			for (int d = 0; d < 4; d++) {
				int nexti = now.i + di[d];
				int nextj = now.j + dj[d];

				if (nexti >= 0 && nexti < R && nextj >= 0 && nextj < C && map[nexti][nextj] == '.') {
					map[nexti][nextj] = '*';
					water.add(new Point(nexti, nextj));
				}
			}
		}
//		printMap();
	}

	private static void printMap() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println("#################");
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
