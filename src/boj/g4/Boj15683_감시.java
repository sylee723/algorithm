package boj.g4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj15683_감시 {
	static int N, M, maxArea;
	static int[][] map;
	static int[] di = { -1, 0, 1, 0 }; // 12시부터 시계방향
	static int[] dj = { 0, 1, 0, -1 };
	static List<CCTV> cctv;
	static int[] result;
	static boolean[][] watched;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		cctv = new ArrayList<>();
		int wall = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				switch (map[i][j]) {
				case 1:
					cctv.add(new CCTV(1, i, j, 4));
					break;
				case 2:
					cctv.add(new CCTV(2, i, j, 2));
					break;
				case 3:
					cctv.add(new CCTV(3, i, j, 4));
					break;
				case 4:
					cctv.add(new CCTV(4, i, j, 4));
					break;
				case 5:
					cctv.add(new CCTV(5, i, j, 1));
					break;
				case 6:
					wall++;
					break;
				}
			}
		}
		result = new int[cctv.size()];
		maxArea = Integer.MIN_VALUE;
		getDir(0);

		System.out.println(M * N - cctv.size() - wall - maxArea);
	}

	static class CCTV {
		int num;
		int i;
		int j;
		int d_num;

		public CCTV(int num, int i, int j, int d_num) {
			super();
			this.num = num;
			this.i = i;
			this.j = j;
			this.d_num = d_num;
		}

		@Override
		public String toString() {
			return "CCTV [num=" + num + ", i=" + i + ", j=" + j + ", d_num=" + d_num + "]";
		}
	}

	static void getDir(int idx) { // idx번째 CCTV의 방향을 결정
		if (idx == cctv.size()) {
			int area = getArea();
			maxArea = Math.max(maxArea, area);
			return;
		}

		for (int d = 0; d < cctv.get(idx).d_num; d++) {
			result[idx] = d;
			getDir(idx + 1);
		}
	}

	private static int getArea() { // 감시 영역 칸수를 리턴
		watched = new boolean[N][M];

		for (int c = 0; c < cctv.size(); c++) {
			boolean[] watchDir = new boolean[4];
			switch (cctv.get(c).num) { // cctv 하나에 대해 탐색 방향 결정
			case 1:
				watchDir[result[c]] = true;
				break;
			case 2:
				if (result[c] == 0) {
					watchDir[0] = true;
					watchDir[2] = true;
				} else if (result[c] == 1) {
					watchDir[1] = true;
					watchDir[3] = true;
				}
				break;
			case 3:
				if (result[c] == 0) {
					watchDir[0] = true;
					watchDir[1] = true;
				} else if (result[c] == 1) {
					watchDir[1] = true;
					watchDir[2] = true;
				} else if (result[c] == 2) {
					watchDir[2] = true;
					watchDir[3] = true;
				} else if (result[c] == 3) {
					watchDir[3] = true;
					watchDir[0] = true;
				}
				break;
			case 4:
				for (int i = 0; i < 4; i++)
					watchDir[i] = true;
				watchDir[result[c]] = false;
				break;
			case 5:
				for (int i = 0; i < 4; i++)
					watchDir[i] = true;
				break;
			}

			for (int d = 0; d < 4; d++) {

				if (!watchDir[d])
					continue;
				CCTV now = cctv.get(c);
				int nowi = now.i;
				int nowj = now.j;
				while (true) {
					int nexti = nowi + di[d];
					int nextj = nowj + dj[d];
					if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= M || map[nexti][nextj] == 6)
						break;

					nowi = nexti;
					nowj = nextj;
					watched[nowi][nowj] = true;
				}
			}
		}

		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (watched[i][j] && map[i][j] == 0) {
					count++;
				}
			}
		}
		return count;
	}
}
