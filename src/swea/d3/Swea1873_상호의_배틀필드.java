package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea1873_상호의_배틀필드 {

	static char[][] map;
	static int H, W, nowi, nowj, nowd;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static char[] tank = { '^', 'v', '<', '>' };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			map = new char[H][W];

			for (int i = 0; i < H; i++) {
				String line = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = line.charAt(j);

					for (int d = 0; d < 4; d++) {
						if (map[i][j] == tank[d]) {
							nowi = i;
							nowj = j;
							nowd = d;
						}
					}
				}
			}

			int N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			for (int n = 0; n < N; n++) {
				switch (input.charAt(n)) {
				case 'U':
					turnAndGo(0);
					break;
				case 'D':
					turnAndGo(1);
					break;
				case 'L':
					turnAndGo(2);
					break;
				case 'R':
					turnAndGo(3);
					break;
				case 'S':
					shoot();
					break;
				}
			}

			System.out.print("#" + tc + " ");
			printMap();
		}
	}

	static void turnAndGo(int dir) {
		nowd = dir;
		int nexti = nowi + di[nowd];
		int nextj = nowj + dj[nowd];

		if (nexti >= 0 && nexti < H && nextj >= 0 && nextj < W && map[nexti][nextj] == '.') {
			map[nowi][nowj] = '.';
			nowi = nexti;
			nowj = nextj;
		}

		map[nowi][nowj] = tank[nowd];
	}

	private static void shoot() {
		int si = nowi;
		int sj = nowj;

		while (true) {
			int nexti = si + di[nowd];
			int nextj = sj + dj[nowd];

			if (nexti < 0 || nexti >= H || nextj < 0 || nextj >= W)
				break;

			si = nexti;
			sj = nextj;

			if (map[si][sj] == '#')
				break;
			else if (map[si][sj] == '*') {
				map[si][sj] = '.';
				break;
			}
		}
	}

	private static void printMap() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
