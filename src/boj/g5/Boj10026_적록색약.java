package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj10026_적록색약 {
	static int N;
	static char[][] board;
	static boolean[][] visited;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new char[N][];
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}

		visited = new boolean[N][N];
		int count1 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs1(i, j);
					count1++;
				}
			}
		}

		visited = new boolean[N][N];
		int count2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs2(i, j, board[i][j]);
					count2++;
				}
			}
		}
		System.out.println(count1 + " " + count2);
	}

	private static void bfs1(int i, int j) { // 적록색약 아닌 경우
		Queue<int[]> queue = new LinkedList<>();
		visited[i][j] = true;
		queue.add(new int[] { i, j });

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nexti = now[0] + di[d];
				int nextj = now[1] + dj[d];

				if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < N && !visited[nexti][nextj]
						&& board[now[0]][now[1]] == board[nexti][nextj]) {
					visited[nexti][nextj] = true;
					queue.add(new int[] { nexti, nextj });
				}
			}
		}
	}

	private static void bfs2(int i, int j, char color) { // 적록색약인 경우
		Queue<int[]> queue = new LinkedList<>();
		visited[i][j] = true;
		queue.add(new int[] { i, j });

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nexti = now[0] + di[d];
				int nextj = now[1] + dj[d];

				if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < N && !visited[nexti][nextj]) {
					if ((color == 'R' || color == 'G') && (board[nexti][nextj] == 'R' || board[nexti][nextj] == 'G')) {
						visited[nexti][nextj] = true;
						queue.add(new int[] { nexti, nextj });
					} else if (color == 'B' && board[nexti][nextj] == 'B') {
						visited[nexti][nextj] = true;
						queue.add(new int[] { nexti, nextj });
					}
				}
			}
		}
	}
}
