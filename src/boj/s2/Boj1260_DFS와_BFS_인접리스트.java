package boj.s2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj1260_DFS와_BFS_인접리스트 {
	static int N;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int m = 0; m < M; m++) {
			int i = sc.nextInt();
			int j = sc.nextInt();

			graph[i].add(j);
			graph[j].add(i);
		}

		for (int i = 1; i <= N; i++) { // 정점 번호 작은 것 부터 방문
			Collections.sort(graph[i]);
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

		for (int num : graph[v]) {
			if (!visited[num])
				dfs(num);
		}

	}

	private static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		visited[v] = true;
		queue.add(v);

		while (!queue.isEmpty()) {
			int now = queue.poll();
			System.out.print(now + " ");

			for (int num : graph[now]) {
				if (!visited[num]) {
					visited[num] = true;
					queue.add(num);
				}
			}
		}
	}
}
