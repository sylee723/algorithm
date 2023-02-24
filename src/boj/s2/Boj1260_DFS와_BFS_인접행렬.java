package boj.s2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj1260_DFS와_BFS_인접행렬 {
	static int N;
	static int[][] graph;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();

		graph = new int[N + 1][N + 1];

		for (int m = 0; m < M; m++) {
			int i = sc.nextInt();
			int j = sc.nextInt();

			graph[i][j] = 1;
			graph[j][i] = 1;
		}

		visited = new boolean[N + 1];
		dfs(V);

		System.out.println();

		visited = new boolean[N + 1];
		bfs(V);
	}

	private static void dfs(int v) {
		visited[v] = true;
		System.out.print(v + " ");

		for (int j = 1; j <= N; j++) {
			if (graph[v][j] == 1 && !visited[j])
				dfs(j);
		}

	}

	private static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		visited[v] = true;
		queue.add(v);

		while (!queue.isEmpty()) {
			int now = queue.poll();
			System.out.print(now + " ");

			for (int j = 1; j <= N; j++) {
				if (graph[now][j] == 1 && !visited[j]) {
					visited[j] = true;
					queue.add(j);
				}
			}
		}
	}
}
