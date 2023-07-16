package boj.g1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj13460_구슬_탈출_2 {
	static int N, M, hi, hj, answer;
	static char[][] board;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new char[N][M];
		int ri = 0, rj = 0, bi = 0, bj = 0;
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = line.charAt(j);
				if (board[i][j] == 'O') {
					hi = i;
					hj = j;
				} else if (board[i][j] == 'R') {
					ri = i;
					rj = j;
					board[i][j] = '.';
				} else if (board[i][j] == 'B') {
					bi = i;
					bj = j;
					board[i][j] = '.';
				}
			}
		}
		Point start = new Point(ri, rj, bi, bj);
		answer = -1;
		bfs(start);

		System.out.println(answer);
	}

	private static void bfs(Point start) {
		boolean[][][][] visited = new boolean[N][M][N][M];
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(start);
		visited[start.ri][start.rj][start.bi][start.bj] = true;
		int move_count = 0;

		while (!queue.isEmpty()) {
			if (move_count > 10) {
				break;
			}
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Point now = queue.poll();

				if ((now.ri == hi && now.rj == hj) && !(now.bi == hi && now.bj == hj)) {
					answer = move_count;
					return;
				}
				for (int d = 0; d < 4; d++) {
					Point next = movePoint(now, d);
					if (!visited[next.ri][next.rj][next.bi][next.bj]) {
						visited[next.ri][next.rj][next.bi][next.bj] = true;
						queue.add(next);
					}
				}

			}
			move_count++;
		}
	}

	private static Point movePoint(Point now, int dir) {
		int first = 0; // 먼저 이동하는 구슬이 빨간색이면 0, 파란색이면 1
		switch (dir) { // 먼저 이동시킬 구슬 선택
		case 0:
			if (now.rj == now.bj && now.ri > now.bi) {
				first = 1;
			}
			break;
		case 1:
			if (now.rj == now.bj && now.ri < now.bi) {
				first = 1;
			}
			break;
		case 2:
			if (now.ri == now.bi && now.rj > now.bj) {
				first = 1;
			}
			break;
		case 3:
			if (now.ri == now.bi && now.rj < now.bj) {
				first = 1;
			}
			break;
		}

		int fi, fj, si, sj;
		if (first == 0) {
			fi = now.ri;
			fj = now.rj;
			si = now.bi;
			sj = now.bj;
		} else {
			fi = now.bi;
			fj = now.bj;
			si = now.ri;
			sj = now.rj;
		}

		int fi_next, fj_next;
		while (true) {
			if (board[fi][fj] == 'O')
				break;

			fi_next = fi + di[dir];
			fj_next = fj + dj[dir];

			if (board[fi_next][fj_next] == '#')
				break;

			fi = fi_next;
			fj = fj_next;
		}

		int si_next, sj_next;
		while (true) {
			if (board[si][sj] == 'O')
				break;

			si_next = si + di[dir];
			sj_next = sj + dj[dir];

			if (board[si_next][sj_next] == '#')
				break;
			if ((si_next == fi && sj_next == fj) && board[si_next][sj_next] != 'O')
				break;
			si = si_next;
			sj = sj_next;
		}

		Point next;
		if (first == 0) {
			next = new Point(fi, fj, si, sj);
		} else {
			next = new Point(si, sj, fi, fj);
		}
		return next;
	}

	static class Point {
		int ri, rj, bi, bj;

		public Point(int ri, int rj, int bi, int bj) {
			this.ri = ri;
			this.rj = rj;
			this.bi = bi;
			this.bj = bj;
		}

		@Override
		public String toString() {
			return "Point [ri=" + ri + ", rj=" + rj + ", bi=" + bi + ", bj=" + bj + "]";
		}

	}
}
