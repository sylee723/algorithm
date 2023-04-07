package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 해결 못함. 진행중
public class Swea1767_프로세서_연결하기 {
	static int N, coreCnt, onCnt, totalLen;
	static ArrayList<Core> core;
	static int[][] map, copy;
	static int[] dir;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			coreCnt = 0;
			core = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						coreCnt++;
						if (i == 0 || j == 0 || i == N - 1 || j == N - 1)
							continue;
						core.add(new Core(i, j)); // 전선 연결해야 할 코어들 저장
					}
				}
			}
			dir = new int[core.size()];
			setDir(0);

		} // end test case
	}

	private static void setDir(int idx) {
		if (idx == core.size()) {
			System.out.println(Arrays.toString(dir));

			deepcopy(map, copy);
			for (int i = 0; i < core.size(); i++) {
				if (!isAvailable(i, dir[i]))
					return;
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			dir[idx] = i;
			setDir(idx + 1);
		}
	}

	private static boolean isAvailable(int idx, int d) {
		Core now = core.get(idx);
		int nexti = now.i + di[d];
		int nextj = now.j + dj[d];
		while (true) {
			if (copy[nexti][nextj] == 1)
				return false;
			if ((nexti == 0 || nexti == N - 1 || nextj == 0 || nextj == N - 1) && copy[nexti][nextj] == 0)
				return true;
			copy[nexti][nextj] = 1;
			nexti += di[d];
			nextj += dj[d];
		}
	}

	private static void deepcopy(int[][] map, int[][] copy) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}

	static class Core {
		int i, j;

		public Core(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}
}
