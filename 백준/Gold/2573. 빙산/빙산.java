import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map, melted;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int year = 1;
		melted = new int[N][M];
		while (true) {
			melting();
			int count = countBerg();
			if (count == 0) {
				year = 0;
				break;
			} else if (count > 1) {
				break;
			}

			year++;
		}

		System.out.println(year);
	}

	private static int countBerg() {
		int count = 0;
		boolean[][] visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] > 0 && !visited[i][j]) {
					bfs(i, j, map, visited);
					count++;
				}
			}
		}
		return count;
	}

	private static void bfs(int si, int sj, int[][] board, boolean[][] visited) {
		Queue<Point> queue = new ArrayDeque<>();
		visited[si][sj] = true;
		queue.add(new Point(si, sj));

		while (!queue.isEmpty()) {
			Point now = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nexti = now.i + di[d];
				int nextj = now.j + dj[d];

				if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M && !visited[nexti][nextj]
						&& board[nexti][nextj] > 0) {
					visited[nexti][nextj] = true;
					queue.add(new Point(nexti, nextj));
				}
			}
		}
	}

	private static void melting() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				melted[i][j] = 0;
			}
		}
		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < M - 1; j++) {
				if (map[i][j] == 0) {
					continue;
				}

				for (int d = 0; d < 4; d++) {
					int ni = i + di[d];
					int nj = j + dj[d];

					if (map[ni][nj] == 0) {
						melted[i][j]++;
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (melted[i][j] == 0) {
					continue;
				}
				map[i][j] = Math.max(map[i][j] - melted[i][j], 0);
			}
		}
	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}