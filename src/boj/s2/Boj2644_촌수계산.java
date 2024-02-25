package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2644_촌수계산 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(br.readLine());
		boolean[][] adjArr = new boolean[N + 1][N + 1];
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			adjArr[x][y] = true;
			adjArr[y][x] = true;
		}

		int answer = bfs(A, B, adjArr);
		System.out.println(answer);
	}

	private static int bfs(int a, int b, boolean[][] adjArr) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[adjArr.length];
		queue.add(a);
		visited[a] = true;

		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				int now = queue.poll();
				if (now == b) {
					return count;
				}

				for (int j = 1; j < adjArr[now].length; j++) {
					if (adjArr[now][j] && !visited[j]) {
						visited[j] = true;
						queue.add(j);
					}
				}
			}
			count++;
		}

		return -1;
	}
}
