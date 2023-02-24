package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Boj2667_단지번호붙이기_BFS {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static List<Integer> house_num;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		visited = new boolean[N][N];
		house_num = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					bfs(i, j);
					count++;
				}
			}
		}

		System.out.println(count);

		Collections.sort(house_num);
		for (int num : house_num) {
			System.out.println(num);
		}
	}

	private static void bfs(int si, int sj) {
		Queue<Point> queue = new LinkedList<>();
		visited[si][sj] = true;
		queue.add(new Point(si, sj));

		int cnt = 0;
		while (!queue.isEmpty()) {
			Point now = queue.poll();
			cnt++;

			for (int d = 0; d < 4; d++) {
				int nexti = now.i + di[d];
				int nextj = now.j + dj[d];

				if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < N && map[nexti][nextj] == 1
						&& !visited[nexti][nextj]) {
					visited[nexti][nextj] = true;
					queue.add(new Point(nexti, nextj));
				}
			}
		}

		house_num.add(cnt);
	}

	static class Point {
		int i;
		int j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
