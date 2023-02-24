package boj.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj3109_빵집 {
	static char[][] map;
	static boolean[][] visited;
	static int[] di = { -1, 0, 1 };
	static int R, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		int count = 0;
		for (int i = 0; i < R; i++) {
			if (pipe(i, 0))
				count++;
		}
		System.out.println(count);
	}

	private static boolean pipe(int nowi, int nowj) {
		if (nowj == C - 1)
			return true;
		if (nowi >= 0 && nowi < R && nowj >= 0 && nowj < C && map[nowi][nowj] == '.' && !visited[nowi][nowj]) {
			visited[nowi][nowj] = true;
			for (int d = 0; d < 3; d++) {
				int nexti = nowi + di[d];
				int nextj = nowj + 1;
				if (pipe(nexti, nextj))
					return true;
			}
		}
		return false;
	}
}
