package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7569_토마토 {
	static int M, N, H;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		Queue<Tomato> queue = new ArrayDeque<>();
		int[][][] box = new int[H][N][M];
		boolean[][][] visited = new boolean[H][N][M];
		int left = 0;
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					box[k][i][j] = Integer.parseInt(st.nextToken());
					if (box[k][i][j] == 1) {
						queue.add(new Tomato(i, j, k));
						visited[k][i][j] = true;
					} else if (box[k][i][j] == 0) {
						left++;
					}
				}
			}
		}

		int answer = bfs(box, left, queue, visited);
		System.out.println(answer);
	}

	private static int bfs(int[][][] box, int left, Queue<Tomato> queue, boolean[][][] visited) {
		int size;
		int day = 0;

		while (!queue.isEmpty()) {
			size = queue.size();
			for (int s = 0; s < size; s++) {
				Tomato now = queue.poll();
				if (box[now.k][now.i][now.j] == 0) {
					left--;
				}
				if (left == 0)
					return day;

				for (int d = 0; d < 4; d++) {
					int nexti = now.i + di[d];
					int nextj = now.j + dj[d];

					if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= M)
						continue;

					if (!visited[now.k][nexti][nextj] && box[now.k][nexti][nextj] == 0) {
						visited[now.k][nexti][nextj] = true;
						queue.add(new Tomato(nexti, nextj, now.k));
					}
				}
				if (now.k + 1 < H) {
					if (!visited[now.k + 1][now.i][now.j] && box[now.k + 1][now.i][now.j] == 0) {
						visited[now.k + 1][now.i][now.j] = true;
						queue.add(new Tomato(now.i, now.j, now.k + 1));
					}
				}
				if (now.k - 1 >= 0) {
					if (!visited[now.k - 1][now.i][now.j] && box[now.k - 1][now.i][now.j] == 0) {
						visited[now.k - 1][now.i][now.j] = true;
						queue.add(new Tomato(now.i, now.j, now.k - 1));
					}
				}
			}
			day++;
		}

		return -1;
	}

	static class Tomato {
		int i, j, k;

		public Tomato(int i, int j, int k) {
			this.i = i;
			this.j = j;
			this.k = k;
		}
	}
}
