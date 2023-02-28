package boj.g1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Boj17472_다리_만들기_2 {
	static int N, M, i_num;
	static int[][] map;
	static boolean[][] visited;
	static List<Dari> dari;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static int[] disjoint;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		i_num = 0;
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					i_num++;
					bfs(i, j);
				}
			}
		}

		dari = new ArrayList<>();

		for (int i = 0; i < N; i++) { // 가로 다리
			int start = -1;
			int end = -1;
			int len = -1;
			int j = 0;

			while (true) {
				if (j >= M)
					break;
				while (j < M && map[i][j] == 0) {
					j++;
				} // 0 시작 제거
				if (j < M && map[i][j] != 0) {
					start = map[i][j];
					while (j < M && map[i][j] == start) {
						j++;
					}
				}
				if (j < M && map[i][j] == 0) {
					len = 0;
					// 다리 길이 계산
					while (j < M && map[i][j] == 0) {
						j++;
						len++;
					}
				}
				if (j < M && map[i][j] != 0) {
					end = map[i][j];
					if (len >= 2) {
						dari.add(new Dari(start, end, len));
					}
				}
			}
		}

		for (int j = 0; j < M; j++) { // 세로 다리
			int start = -1;
			int end = -1;
			int len = -1;
			int i = 0;

			while (true) {
				if (i >= N)
					break;
				while (i < N && map[i][j] == 0) {
					i++;
				} // 0 시작 제거
				if (i < N && map[i][j] != 0) {
					start = map[i][j];
					while (i < N && map[i][j] == start) {
						i++;
					}
				}
				if (i < N && map[i][j] == 0) {
					len = 0;
					// 다리 길이 계산
					while (i < N && map[i][j] == 0) {
						i++;
						len++;
					}
				}
				if (i < N && map[i][j] != 0) {
					end = map[i][j];
					if (len >= 2) {
						dari.add(new Dari(start, end, len));
					}
				}
			}
		}

		Collections.sort(dari); // 다리 길이 짧은 순서대로 정렬
		
		disjoint = new int[i_num + 1];
		for (int i = 1; i <= i_num; i++) {
			disjoint[i] = i;
		}

		int s = 0;
		int e = 0;
		int result = 0;
		for (int i = 0; i < dari.size(); i++) {
			Dari nowD = dari.get(i);
			s = nowD.start;
			e = nowD.end;
			if (union(nowD.start, nowD.end)) {
				result += nowD.length;
			}
		}

		int check = findSet(1);
		for (int i = 2; i <= i_num; i++) {
			if (check != findSet(i)) { // 다리 연결 실패
				result = -1;
				break;
			}
		}
		
		System.out.println(result);
	}

	static int findSet(int i) {
		if (i == disjoint[i])
			return i;
		else
			return disjoint[i] = findSet(disjoint[i]);
	}

	static boolean union(int n1, int n2) {
		int p1 = findSet(n1);
		int p2 = findSet(n2);

		if (p1 == p2)
			return false;

		disjoint[p1] = p2;
		return true;
	}

	private static void bfs(int i, int j) {
		Queue<Point> queue = new LinkedList<>();
		visited[i][j] = true;
		queue.add(new Point(i, j));

		while (!queue.isEmpty()) {
			Point now = queue.poll();
			map[now.i][now.j] = i_num;

			for (int d = 0; d < 4; d++) {
				int nexti = now.i + di[d];
				int nextj = now.j + dj[d];

				if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M && !visited[nexti][nextj]
						&& map[nexti][nextj] == 1) {
					visited[nexti][nextj] = true;
					queue.add(new Point(nexti, nextj));
				}
			}
		}
	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			return "Point [i=" + i + ", j=" + j + "]";
		}
	}

	static class Dari implements Comparable<Dari> {
		int start, end, length;

		public Dari(int start, int end, int length) {
			super();
			this.start = start;
			this.end = end;
			this.length = length;
		}

		@Override
		public String toString() {
			return "Dari [start=" + start + ", end=" + end + ", length=" + length + "]";
		}

		@Override
		public int compareTo(Dari o) {
			return Integer.compare(this.length, o.length);
		}
	}

}
