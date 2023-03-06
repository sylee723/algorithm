package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7576_토마토 {
	static int M, N, days;
	static int[][] map;
	static boolean[][] visited;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[N][M];

		days = -1;
		ArrayList<Point> tomato = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					tomato.add(new Point(i, j));
				}
			}
		}
		bfs(tomato);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) { // 익지 않은 토마토가 있으면
					days = -1;
					break;
				}
			}
		}

		System.out.println(days);
	}

	private static void bfs(ArrayList<Point> start) {
		Queue<Point> queue = new LinkedList<>();

		for (int i = 0; i < start.size(); i++) {
			Point s = start.get(i);
			visited[s.i][s.j] = true;
			queue.add(new Point(s.i, s.j));
		}

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int n = 0; n < size; n++) {
				Point now = queue.poll();

				for (int d = 0; d < 4; d++) {
					int nexti = now.i + di[d];
					int nextj = now.j + dj[d];

					if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M && map[nexti][nextj] == 0
							&& !visited[nexti][nextj]) {
						map[nexti][nextj] = 1;
						visited[nexti][nextj] = true;
						queue.add(new Point(nexti, nextj));
					}
				}
			}
			days++;
		}

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
