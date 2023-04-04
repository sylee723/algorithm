package boj.g1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 틀렸습니다
public class Boj1194_달이_차오른다_가자 {
	static int N, M;
	static char[][] map;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		int nowi = -1, nowj = -1;
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == '0') {
					nowi = i;
					nowj = j;
					map[i][j] = '.';
				}
			}
		}
		System.out.println(bfs(nowi, nowj));
	}

	private static int bfs(int nowi, int nowj) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(nowi, nowj, 0));
		boolean[][][] visited = new boolean[N][M][64];
		visited[nowi][nowj][0] = true;
		int time = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Point now = queue.poll();
				if (map[now.i][now.j] == '1') {
					return time;
				}

				for (int d = 0; d < 4; d++) {
					int nexti = now.i + di[d];
					int nextj = now.j + dj[d];
					int nextkey = now.key;
					if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= M || map[nexti][nextj] == '#'
							|| visited[nexti][nextj][nextkey])
						continue;

					if (map[nexti][nextj] >= 'a' && map[nexti][nextj] <= 'f') { // 열쇠를 집는 경우
						nextkey = nextkey | (1 << (map[nexti][nextj] - 'a'));
						map[nexti][nextj] = '.';
					} else if (map[nexti][nextj] >= 'A' && map[nexti][nextj] <= 'F') { // 문. 대응하는 열쇠가 있는지 확인
						if (((1 << (map[nexti][nextj] - 'A')) & nextkey) == 0) // 대응하는 키가 없으면 이동 못함
							continue;
					}

					// 이동
					queue.add(new Point(nexti, nextj, nextkey));
					visited[nexti][nextj][nextkey] = true;
				}
			}
			time++;
		}
		return -1;
	}

	static class Point {
		int i, j, key;

		public Point(int i, int j, int key) {
			super();
			this.i = i;
			this.j = j;
			this.key = key;
		}
	}
}
