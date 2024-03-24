package boj.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj16235_나무_재테크 {
	static int[] di = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dj = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] A = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ArrayList<Integer>[][] tree = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tree[i][j] = new ArrayList<>();
			}
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			tree[x - 1][y - 1].add(z);
		}

		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = 5;
			}
		}

		for (int year = 0; year < K; year++) {
			ArrayList<Point> deadTree = spring(tree, map);
			summer(deadTree, map);
			fall(tree);
			winter(map, A);
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				answer += tree[i][j].size();
			}
		}

		System.out.println(answer);
	}

	private static ArrayList<Point> spring(ArrayList<Integer>[][] tree, int[][] map) {
		ArrayList<Point> dead = new ArrayList<>();
		for (int i = 0; i < tree.length; i++) {
			for (int j = 0; j < tree.length; j++) {
				if (tree[i][j].size() == 0) {
					continue;
				}

				Collections.sort(tree[i][j]);

				ArrayList<Integer> deadIdx = new ArrayList<>();
				for (int t = 0; t < tree[i][j].size(); t++) {
					int age = tree[i][j].get(t);
					if (age <= map[i][j]) {
						map[i][j] -= age;
						tree[i][j].set(t, age + 1);
					} else {
						dead.add(new Point(i, j, age));
						deadIdx.add(t);
					}
				}

				for (int d = deadIdx.size() - 1; d >= 0; d--) {
					int idx = deadIdx.get(d);
					tree[i][j].remove(idx);
				}
			}
		}

		return dead;
	}

	private static void summer(ArrayList<Point> deadTree, int[][] map) {
		for (Point tree : deadTree) {
			map[tree.i][tree.j] += tree.age / 2;
		}
	}

	private static void fall(ArrayList<Integer>[][] tree) {
		int N = tree.length;
		int[][] treeCnt = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int age : tree[i][j]) {
					if (age % 5 == 0) {
						treeCnt[i][j]++;
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (treeCnt[i][j] == 0) {
					continue;
				}

				for (int d = 0; d < 8; d++) {
					int ni = i + di[d];
					int nj = j + dj[d];

					if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
						for (int c = 0; c < treeCnt[i][j]; c++) {
							tree[ni][nj].add(1);
						}
					}
				}
			}
		}
	}

	private static void winter(int[][] map, int[][] A) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				map[i][j] += A[i][j];
			}
		}
	}

	static class Point {
		int i, j, age;

		public Point(int i, int j, int age) {
			this.i = i;
			this.j = j;
			this.age = age;
		}

		@Override
		public String toString() {
			return "Point [i=" + i + ", j=" + j + ", age=" + age + "]";
		}
	}
}
