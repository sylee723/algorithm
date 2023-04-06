package boj.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj16236_아기_상어 {
	static int N, shi, shj, time, shSize, eatCnt;
	static int[][] map;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					shi = i;
					shj = j;
					map[i][j] = 0;
				}
			}
		}

		shSize = 2;
		eatCnt = 0;
		while (true) {
			if (!eatFish())
				break;
//			for (int i = 0; i <N; i ++) {
//				for (int j = 0; j <N; j++) {
//					if (i == shi && j == shj) {
//						System.out.print("<"+shSize+">");
//					} else {
//						System.out.print(" "+map[i][j]+" ");
//					}
//				}
//				System.out.println();
//			}
		}
		System.out.println(time);
	}

	private static boolean eatFish() {
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(shi, shj));
		boolean[][] visited = new boolean[N][N];
		visited[shi][shj] = true;

		int dist = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			ArrayList<Point> targetList = new ArrayList<>();
			for (int s = 0; s < size; s++) {
				Point now = queue.poll();
				if (map[now.i][now.j] > 0 && map[now.i][now.j] < shSize) {
					targetList.add(now);
				}
				for (int d = 0; d < 4; d++) {
					int nexti = now.i + di[d];
					int nextj = now.j + dj[d];

					if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < N && !visited[nexti][nextj]
							&& map[nexti][nextj] <= shSize) {
						visited[nexti][nextj] = true;
						queue.add(new Point(nexti, nextj));
					}
				}
			}

			if (!targetList.isEmpty()) { // 거리가 가까운 물고기 중 가장 위, 가장 왼쪽에 있는 물고기 고르기
//				System.out.println(targetList);
				Point target = null;
				int min_i = Integer.MAX_VALUE;
				int min_j = Integer.MAX_VALUE;
				for (Point fish : targetList) {
					if (min_i > fish.i) {
						min_i = fish.i;
						min_j = fish.j;
						target = fish;
					} else if (min_i == fish.i) {
						if (min_j > fish.j) {
							min_j = fish.j;
							target = fish;
						}
					}
				}

				// target 물고기 먹기
//				System.out.println("타겟 물고기: "+target);
				shi = target.i;
				shj = target.j;
				map[shi][shj] = 0;
				eatCnt++;
				if (eatCnt == shSize) {
					shSize++;
					eatCnt = 0;
				}
				time += dist;
				return true;
			}
			dist++;
		}

		return false; // 물고기를 못먹으면 false 리턴
	}

	static class Point {

		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			return "Point [i=" + i + ", j=" + j + "]";
		}
	}
}
