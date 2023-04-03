package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2636_치즈 {
	static int N, M;
	static int[][] map;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		int leftCnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					leftCnt++;
				}
			}
		}
		boolean[][] melting;
		int count = 0, time = 0;
		while (leftCnt > 0) {
			// 가장자리 영역을 구하는 함수. 가장자리는 melting 배열에 true로 저장
			melting = getMeltingArea();
			// 치즈 녹는 함수. 가장 자리가 녹고, 녹은 칸의 수가 리턴
			count = melt(melting);

			leftCnt -= count;
			time++;
		}
		System.out.println(time);
		System.out.println(count);
	}

	private static int melt(boolean[][] melting) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && melting[i][j]) {
					map[i][j] = 0;
					count++;
				}
			}
		}
		return count;
	}

	// BFS
	private static boolean[][] getMeltingArea() {
		boolean[][] m = new boolean[N][M];
		Queue<Point> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		queue.add(new Point(0, 0));
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			Point now = queue.poll();
			int nexti, nextj;
			for (int d = 0; d < 4; d++) {
				nexti = now.i + di[d];
				nextj = now.j + dj[d];

				if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M && !visited[nexti][nextj]) {
					visited[nexti][nextj] = true;
					if (map[nexti][nextj] == 0) {
						queue.add(new Point(nexti, nextj));
					} else {
						m[nexti][nextj] = true;
					}
				}
			}
		}

		return m;
	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
