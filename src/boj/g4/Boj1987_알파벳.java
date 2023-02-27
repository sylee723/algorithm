package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 해결 못함
public class Boj1987_알파벳 {
	static int R, C, count;
	static char[][] board;
	static boolean[] used;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new char[R][];
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}

		used = new boolean[26]; // 사용된 알파벳인지 체크

		count = 0;
		dfs(0, 0);

		System.out.println(count);
//		for(int i = 0; i<used.length;i++) {
//			if(used[i]) {
//				System.out.print((char)(i + 'A') + " ");
//			}
//		}
	}

	private static void dfs(int si, int sj) {
		used[board[si][sj] - 'A'] = true;
		count++;
		for (int d = 0; d < 4; d++) {
			int nexti = si + di[d];
			int nextj = sj + dj[d];

			if (nexti >= 0 && nexti < R && nextj >= 0 && nextj < C 
					&& !used[board[nexti][nextj] - 'A']) {
				dfs(nexti, nextj);
			}
		}
		used[board[si][sj] - 'A'] = false;
	}

	static class Point {
		int i;
		int j;

		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}
}
