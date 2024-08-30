import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] di = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dj = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		visited = new boolean[300][300];

		StringTokenizer st;
		for (int tc = 0; tc < TC; tc++) {
			init();
			int L = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			int si = Integer.parseInt(st.nextToken());
			int sj = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int ei = Integer.parseInt(st.nextToken());
			int ej = Integer.parseInt(st.nextToken());

			System.out.println(bfs(L, si, sj, ei, ej));
		}
	}

	private static int bfs(int L, int si, int sj, int ei, int ej) {
		Queue<Point> queue = new ArrayDeque<>();
		visited[si][sj] = true;
		queue.add(new Point(si, sj));

		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Point now = queue.poll();
				if (now.i == ei && now.j == ej) {
					return count;
				}

				for (int d = 0; d < di.length; d++) {
					int nexti = now.i + di[d];
					int nextj = now.j + dj[d];

					if (nexti < 0 || nexti >= L || nextj < 0 || nextj >= L || visited[nexti][nextj]) {
						continue;
					}

					visited[nexti][nextj] = true;
					queue.add(new Point(nexti, nextj));
				}
			}

			count++;
		}

		return -1;
	}

	private static void init() {
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[i].length; j++) {
				visited[i][j] = false;
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