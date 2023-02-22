package boj.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 해결 못함
public class Boj3109_빵집 {
	static char[][] map;
	static boolean[][] visited;
	static int[] di = { -1, 0, 1 };
	static int R, C, count;

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

		count = 0;
		for (int i = 0; i < R; i++) {
			pipe(i, 0);
		}
		pipe(3, 0);
		System.out.println(count);
	}

	static void pipe(int si, int sj) {
		if (!isAvailable(si, sj)) {
			System.out.println("si, sj,  boolean :"+ si +", "+false);			
			return;
		}
		System.out.println("si, boolean :"+ si +", "+true);
		count++;

		int nowi = si;
		int nowj = sj;
		while (true) {
			if (nowj == C - 1)
				break;
			visited[nowi][nowj] = true;
			map[nowi][nowj] = '#';
			
			for (int d = 0; d < 3; d++) {
				int nexti = nowi + di[d];
				int nextj = nowj + 1;
				if (nexti >= 0 && nexti < R && nextj < C && !visited[nexti][nextj] && map[nexti][nextj] == '.') {
					nowi = nexti;
					nowj = nextj;
					break;
				}
			}
		}

		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	static boolean isAvailable(int i, int j) {
		if (j == C - 1) {
			return true;
		}

		for (int d = 0; d < 3; d++) {
			int ni = i + di[d];
			int nj = j + 1;
			if (ni >= 0 && ni < R && nj < C && !visited[ni][nj] && map[ni][nj] == '.') {
				return isAvailable(ni, nj);
			}
		}
		
		return false;
	}
}
