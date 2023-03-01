package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea1238_Contact {
	static int[][] adjMatrix;
	static boolean[] visited;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int TC = 10;
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			adjMatrix = new int[101][101];
			visited = new boolean[101];
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N / 2; n++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjMatrix[from][to] = 1;
			}

			bfs(start);

			System.out.println("#" + tc + " " + answer);
		}
	}

	private static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		visited[v] = true;
		queue.add(v);

		while (!queue.isEmpty()) {
			int size = queue.size();
			answer = -1;
			while (size > 0) {
				int now = queue.poll();
				answer = Math.max(answer, now);

				for (int j = 0; j <= 100; j++) {
					if (!visited[j] && adjMatrix[now][j] == 1) {
						visited[j] = true;
						queue.add(j);
					}
				}
				size--;
			}
		}
	}
}
