package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj16234_인구_이동 {
	static int N, L, R;
	static int[][] map;
	static ArrayList<Integer>[] adjList;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int day = 0;
		adjList = new ArrayList[N * N];

		for (int i = 0; i < N * N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}

		while (true) {
			if (!move()) {
				break;
			}
			day++;
		}

		System.out.println(day);
	}

	private static boolean move() {
		for (int i = 0; i < N * N; i++) {
			adjList[i].clear();
		}

		boolean isOpen = false;
		// 세로 국경선
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				int diff = Math.abs(map[i][j] - map[i][j + 1]);
				if (diff >= L && diff <= R) {
					int a = i * N + j;
					int b = i * N + j + 1;

					adjList[a].add(b);
					adjList[b].add(a);

					isOpen = true;
				}
			}
		}
		// 가로 국경선
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < N; j++) {
				int diff = Math.abs(map[i][j] - map[i + 1][j]);
				if (diff >= L && diff <= R) {
					int a = i * N + j;
					int b = (i + 1) * N + j;

					adjList[a].add(b);
					adjList[b].add(a);

					isOpen = true;
				}
			}
		}

		visited = new boolean[N][N];
		Set<Point> union = new HashSet<>();

		if (isOpen) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int num = i * N + j;
					if (!visited[i][j] && !adjList[num].isEmpty()) {

						int population = bfs(new Point(i, j), union) / union.size();

						for (Point p : union) {
							map[p.i][p.j] = population;
						}
						union.clear();
					}
				}
			}
		}

		return isOpen;
	}

	private static int bfs(Point start, Set<Point> union) {
		Queue<Point> queue = new ArrayDeque<>();
		visited[start.i][start.j] = true;
		queue.add(start);

		int total = 0;

		while (!queue.isEmpty()) {
			Point now = queue.poll();
			union.add(now);
			total += map[now.i][now.j];
			int num = now.i * N + now.j;

			for (int i = 0; i < adjList[num].size(); i++) {
				int nextNum = adjList[num].get(i);
				int nexti = nextNum / N;
				int nextj = nextNum % N;

				if (!visited[nexti][nextj]) {
					visited[nexti][nextj] = true;
					queue.add(new Point(nexti, nextj));
				}
			}
		}
		return total;
	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
