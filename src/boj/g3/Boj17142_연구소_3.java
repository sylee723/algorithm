package boj.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj17142_연구소_3 {
	static int N, M, emptyCount, minTime;
	static int[][] map;
	static boolean[] selected;
	static ArrayList<Point> virusList;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		virusList = new ArrayList<>();
		emptyCount = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 0) {
					emptyCount++;
				} else if (map[i][j] == 2) {
					virusList.add(new Point(i, j));
				}

			}
		}

		selected = new boolean[virusList.size()];
		minTime = Integer.MAX_VALUE;

		if (emptyCount == 0) {
			minTime = 0;
		} else {
			comb(0, 0);

			if (minTime == Integer.MAX_VALUE)
				minTime = -1;
		}

		System.out.println(minTime);
	}

	private static void comb(int idx, int count) {
		if (count == M) {
			bfs();
			return;
		}

		if (idx == virusList.size())
			return;

		if (count < M) {
			selected[idx] = true;
			comb(idx + 1, count + 1);
		}
		selected[idx] = false;
		comb(idx + 1, count);
	}

	private static void bfs() {
		Queue<Point> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];

		for (int i = 0; i < selected.length; i++) {
			if (selected[i]) {
				Point virus = virusList.get(i);
				queue.add(virus);
				visited[virus.i][virus.j] = true;
			}
		}

		int time = 0;
		int count = emptyCount;

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int s = 0; s < size; s++) {
				Point now = queue.poll();
				if (map[now.i][now.j] == 0) {
					count--;
				}

				if (count == 0) {
					minTime = Math.min(minTime, time);
					return;
				}

				for (int d = 0; d < 4; d++) {
					int nexti = now.i + di[d];
					int nextj = now.j + dj[d];

					if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= N)
						continue;

					if (!visited[nexti][nextj] && map[nexti][nextj] != 1) {
						visited[nexti][nextj] = true;
						queue.add(new Point(nexti, nextj));
					}
				}
			}
			time++;
		}
	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			return "Point [i=" + i + ", j=" + j + "]";
		}

	}
}
