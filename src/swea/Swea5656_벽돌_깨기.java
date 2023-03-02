package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea5656_벽돌_깨기 {
	static int N, W, H, minCnt;
	static int[] result;
	static int[][] origin, map;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			origin = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					origin[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			result = new int[N];
			minCnt = Integer.MAX_VALUE;
			perm(0);

			System.out.println("#" + tc + " " + minCnt);

		}
	}

	private static void perm(int idx) {
		if (idx == N) {
			map = deepcopy(origin);
			game();

			int count = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] != 0)
						count++;
				}
			}
			minCnt = Math.min(minCnt, count);

			return;
		}

		for (int i = 0; i < W; i++) {
			result[idx] = i;
			perm(idx + 1);
		}
	}

	private static void game() {
		for (int t = 0; t < N; t++) {
			int c = result[t];

			Queue<Point> queue = new LinkedList<>();
			int r = 0;
			while (r < H && map[r][c] == 0) {
				r++;
			}
			if (r == H)
				continue; // 해당 열의 벽돌 없는 것

			boolean[][] visited = new boolean[H][W];
			visited[r][c] = true;
			queue.add(new Point(r, c));

			while (!queue.isEmpty()) { // 벽돌 깨기
				Point now = queue.poll();

				int len = map[now.i][now.j] - 1;
				map[now.i][now.j] = 0;

				for (int d = 0; d < 4; d++) {
					for (int l = 1; l <= len; l++) {
						int nexti = now.i + di[d] * l;
						int nextj = now.j + dj[d] * l;

						if (nexti >= 0 && nexti < H && nextj >= 0 && nextj < W && !visited[nexti][nextj]
								&& map[nexti][nextj] != 0) {
							visited[nexti][nextj] = true;
							queue.add(new Point(nexti, nextj));
						}
					}
				}
			}

			for (int j = 0; j < W; j++) { // 남은 벽돌 밑으로 떨어짐
				int checki = H - 1;
				int i = H - 1;
				while (true) {
					if (checki < 0)
						break;
					if (map[checki][j] != 0) {
						map[i][j] = map[checki][j];
						if (checki < i)
							map[checki][j] = 0;
						i--;
					}
					checki--;
				}
			}

//			for (int i = 0; i < H; i++) {
//				for(int j =0; j <W; j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println("##################################");
		}
	}

	private static int[][] deepcopy(int[][] origin) {
		int[][] tmp = new int[origin.length][origin[0].length];

		for (int i = 0; i < origin.length; i++) {
			for (int j = 0; j < origin[0].length; j++) {
				tmp[i][j] = origin[i][j];
			}
		}

		return tmp;
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
