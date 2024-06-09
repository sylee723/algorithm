package boj.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1520_내리막_길 {
	static int N, M;
	static int[][] map, rCnt;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		rCnt = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				rCnt[i][j] = -1;
			}
		}

		rCnt[0][0] = 1;
		System.out.println(countRoute(N - 1, M - 1));
	}

	private static int countRoute(int i, int j) {
		if (rCnt[i][j] != -1) {
			return rCnt[i][j];
		}

		int count = 0;
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];

			if (ni >= 0 && ni < N && nj >= 0 && nj < M && map[i][j] < map[ni][nj]) {
				rCnt[ni][nj] = countRoute(ni, nj);
				count += rCnt[ni][nj];
			}
		}

		rCnt[i][j] = count;
		return count;
	}
}
