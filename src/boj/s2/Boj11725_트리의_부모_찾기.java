package boj.s2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Boj11725_트리의_부모_찾기 {
	static int[] parent;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		ArrayList<Integer>[] tree = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			tree[a].add(b);
			tree[b].add(a);
		}
		parent = new int[N + 1];

		bfs(tree);

		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			sb.append(parent[i]).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void bfs(ArrayList<Integer>[] tree) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[tree.length];

		visited[1] = true;
		queue.add(1);

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int next : tree[now]) {
				if (!visited[next]) {
					parent[next] = now;
					visited[next] = true;
					queue.add(next);
				}
			}
		}
	}
}
