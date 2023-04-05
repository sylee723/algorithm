package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea4014_활주로_건설 {
	static int N, L;
	static int[][] map;
	static boolean[][] used;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			used = new boolean[N][N];

			// 행 확인
			boolean check;
			boolean[] r_road = new boolean[N];
			for (int i = 0; i < N; i++) {
				check = true;
				for (int j = 1; j < N; j++) {
					// 경사로 필요한지 검사 (높이 다른지)
					if (map[i][j - 1] == map[i][j]) {
						continue;
					} else if (Math.abs(map[i][j - 1] - map[i][j]) >= 2) { // 높이 2 이상 차이나면 멈춤
						check = false;
						break;
					} else { // 높이 1 차이
						if (!checkRow(i, j - 1)) {
							check = false;
							break;
						}
					}
				}

				if (check)
					r_road[i] = true;
			}

			used = new boolean[N][N];
			// 열 확인
			boolean[] c_road = new boolean[N];
			for (int j = 0; j < N; j++) {
				check = true;
				for (int i = 1; i < N; i++) {
					// 경사로 필요한지 검사 (높이 다른지)
					if (map[i - 1][j] == map[i][j]) {
						continue;
					} else if (Math.abs(map[i - 1][j] - map[i][j]) >= 2) { // 높이 2 이상 차이나면 멈춤
						check = false;
						break;
					} else { // 높이 1 차이
						if (!checkCol(j, i - 1)) {
							check = false;
							break;
						}
					}
				}

				if (check)
					c_road[j] = true;
			}

			int answer = 0;
			for (int i = 0; i < N; i++) {
				if (r_road[i])
					answer++;
				if (c_road[i])
					answer++;
			}

			System.out.println("#" + tc + " " + answer);
		}
	}

	private static boolean checkRow(int r, int i) {
		int si;
		int d;
		if (map[r][i] > map[r][i + 1]) {
			si = i + 1;
			d = 1;
		} else {
			si = i;
			d = -1;
		}

		int nexti;
		for (int l = 0; l < L; l++) {
			nexti = si + d * l;
			if (nexti < 0 || nexti >= N || used[r][nexti])
				return false;
			used[r][nexti] = true;
		}
		return true;
	}

	private static boolean checkCol(int c, int i) {
		int si;
		int d;
		if (map[i][c] > map[i + 1][c]) {
			si = i + 1;
			d = 1;
		} else {
			si = i;
			d = -1;
		}

		int nexti;
		for (int l = 0; l < L; l++) {
			nexti = si + d * l;
			if (nexti < 0 || nexti >= N || used[nexti][c])
				return false;
			used[nexti][c] = true;
		}
		return true;
	}
}
