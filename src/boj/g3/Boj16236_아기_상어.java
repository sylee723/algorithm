package boj.g3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

// 해결 못함. 진행중. 다시 생각
public class Boj16236_아기_상어 {
	static int N, sharkSize, fishCnt;
	static int[][] map;
	static boolean[][] visited;
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];

		int nowi = -1, nowj = -1;
		fishCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 9) {
					nowi = i;
					nowj = j;
					map[i][j] = 0;
				} else if (map[i][j]>=1 && map[i][j] <=6) {
					fishCnt++;
				}
			}
		}

		sharkSize = 2;
		visited = new boolean[N][N];
		
		bfs(nowi, nowj);
	}

	private static int bfs(int nowi, int nowj) {
		Queue<Shark> queue = new ArrayDeque<>();
		queue.add(new Shark(nowi, nowj));
		visited[nowi][nowj] = true;
		
		int time = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s=0; s<size; s++) {
				Point shark = queue.poll();
				if
			
			}
		}
		
	}

	static class Shark {
		int i, j, size;

		public Shark(int i, int j, int size) {
			this.i = i;
			this.j = j;
			this.size = size;
		}
	}
}
