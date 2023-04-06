package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 해결 못함. 진행중
public class Swea1249_보급로 {
	static int N, answer;
	static int[][] map;
	static boolean[][] visited;
	static int[] di = { 1, 0, 0, -1, };
	static int[] dj = { 0, 1, -1, 0, };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j) - '0';
				}
			}
			answer = Integer.MAX_VALUE;
			visited = new boolean[N][N];
			visited[0][0] = true;
			dfs(0, 0, 0);

			System.out.println("#" + tc + " " + answer);
		}
	}

	private static void dfs(int i, int j, int time) {
		if (time >= answer)
			return;

		if (i == N - 1 && j == N - 1) {
			answer = Math.min(answer, time);
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nexti = i + di[d];
			int nextj = j + dj[d];

			if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < N && !visited[nexti][nextj]) {
				visited[nexti][nextj] = true;
				dfs(nexti, nextj, time + map[nexti][nextj]);
				visited[nexti][nextj] = false;
			}
		}
	}
}
