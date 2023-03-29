package boj.g5;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Boj17070_파이프_옮기기_1_DFS_BFS {
	static int[][] map;
	static int N, count1, count2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

//		count1 = 0;
//		dfs(new Pipe(1, 2, 0));
//		System.out.println(count1);

///////////////////////////////////////////////
		count2 = 0;
		bfs(new Pipe(1, 2, 0));
		System.out.println(count2);
	}

	private static void dfs(Pipe pipe) {
		if (pipe.i == N && pipe.j == N) {
			count1++;
			return;
		}

		int i = pipe.i;
		int j = pipe.j;
		switch (pipe.type) {
		case 0: // 가로 파이프
			if (j + 1 <= N && map[i][j + 1] == 0) {
				dfs(new Pipe(i, j + 1, 0));
			}
			if (i + 1 <= N && j + 1 <= N && map[i][j + 1] == 0 && map[i + 1][j] == 0 && map[i + 1][j + 1] == 0) {
				dfs(new Pipe(i + 1, j + 1, 2));
			}
			break;
		case 1: // 세로 파이프
			if (i + 1 <= N && map[i + 1][j] == 0) {
				dfs(new Pipe(i + 1, j, 1));
			}
			if (i + 1 <= N && j + 1 <= N && map[i][j + 1] == 0 && map[i + 1][j] == 0 && map[i + 1][j + 1] == 0) {
				dfs(new Pipe(i + 1, j + 1, 2));
			}
			break;
		case 2: // 대각선 파이프
			if (j + 1 <= N && map[i][j + 1] == 0) {
				dfs(new Pipe(i, j + 1, 0));
			}
			if (i + 1 <= N && map[i + 1][j] == 0) {
				dfs(new Pipe(i + 1, j, 1));
			}
			if (i + 1 <= N && j + 1 <= N && map[i][j + 1] == 0 && map[i + 1][j] == 0 && map[i + 1][j + 1] == 0) {
				dfs(new Pipe(i + 1, j + 1, 2));
			}
			break;
		}
	}

	private static void bfs(Pipe pipe) {
		Queue<Pipe> queue = new ArrayDeque<>();
		queue.add(pipe);

		while (!queue.isEmpty()) {
			Pipe now = queue.poll();
			if (now.i == N && now.j == N) {
				count2++;
			}

			int i = now.i;
			int j = now.j;
			switch (now.type) {
			case 0: // 가로 파이프
				if (j + 1 <= N && map[i][j + 1] == 0) {
					queue.add(new Pipe(i, j + 1, 0));
				}
				if (i + 1 <= N && j + 1 <= N && map[i][j + 1] == 0 && map[i + 1][j] == 0 && map[i + 1][j + 1] == 0) {
					queue.add(new Pipe(i + 1, j + 1, 2));
				}
				break;
			case 1: // 세로 파이프
				if (i + 1 <= N && map[i + 1][j] == 0) {
					queue.add(new Pipe(i + 1, j, 1));
				}
				if (i + 1 <= N && j + 1 <= N && map[i][j + 1] == 0 && map[i + 1][j] == 0 && map[i + 1][j + 1] == 0) {
					queue.add(new Pipe(i + 1, j + 1, 2));
				}
				break;
			case 2: // 대각선 파이프
				if (j + 1 <= N && map[i][j + 1] == 0) {
					queue.add(new Pipe(i, j + 1, 0));
				}
				if (i + 1 <= N && map[i + 1][j] == 0) {
					queue.add(new Pipe(i + 1, j, 1));
				}
				if (i + 1 <= N && j + 1 <= N && map[i][j + 1] == 0 && map[i + 1][j] == 0 && map[i + 1][j + 1] == 0) {
					queue.add(new Pipe(i + 1, j + 1, 2));
				}
				break;
			}
		}

	}

	static class Pipe {
		int i, j, type;

		public Pipe(int i, int j, int type) {
			this.i = i;
			this.j = j;
			this.type = type; // 0이면 가로, 1이면 세로, 2이면 대각선
		}
	}
}
