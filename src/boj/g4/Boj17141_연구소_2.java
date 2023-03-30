package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj17141_연구소_2 {
	static int N, M, max_virus, min_time;
	static int[][] map, copy;
	static ArrayList<Point> point;
	static boolean[] selected;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		point = new ArrayList<>();

		max_virus = N * N;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 2) {
					point.add(new Point(i, j));
					map[i][j] = 0;
				} else if (map[i][j] == 1) {
					max_virus--;
				}
			}
		}

		selected = new boolean[point.size()];
		min_time = Integer.MAX_VALUE;
		comb(0, 0);
		if (min_time == Integer.MAX_VALUE) {
			min_time = -1;
		}

		System.out.println(min_time);
	}

	private static void comb(int idx, int cnt) {
		if (cnt == M) {
			copy = new int[N][N];
			deepcopy(map, copy);
			int time = bfs(copy);
			if (time != -1) {
				min_time = Math.min(min_time, time);
			}
			return;
		}
		
		if (idx == point.size()) {
			return;
		}

		selected[idx] = true;
		comb(idx + 1, cnt + 1);
		selected[idx] = false;
		comb(idx + 1, cnt);
	}

	private static void deepcopy(int[][] map, int[][] copy) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}

	private static int bfs(int[][] map) {
		boolean[][] visited = new boolean[N][N];
		Queue<Point> queue = new ArrayDeque<>();
		for (int i = 0; i < selected.length; i++) {
			if (selected[i]) {
				queue.add(point.get(i));
				visited[point.get(i).i][point.get(i).j] = true;
			}
		}
		int count = M;
		int time = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			if (count == max_virus) {
				return time;
			}
			for (int s = 0; s < size; s++) {
				Point now = queue.poll();
				for (int d = 0; d < 4; d++) {
					int nexti = now.i + di[d];
					int nextj = now.j + dj[d];

					if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < N && map[nexti][nextj] != 1
							&& !visited[nexti][nextj]) {
						queue.add(new Point(nexti, nextj));
						visited[nexti][nextj] = true;
						count++;
					}
				}
			}
			time++;
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
