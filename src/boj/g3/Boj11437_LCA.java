package boj.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj11437_LCA {
	static int[] depth, parent;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		ArrayList<Integer>[] tree = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}
		StringTokenizer st;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			tree[a].add(b);
			tree[b].add(a);
		}

		depth = new int[N + 1];
		parent = new int[N + 1];

		setDepthAndParent(tree);

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			System.out.println(LCA(a, b));
		}
	}

	private static void setDepthAndParent(ArrayList<Integer>[] tree) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[tree.length];
		parent[1] = 0;

		visited[1] = true;
		queue.add(1);

		int d = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int s = 0; s < size; s++) {
				int now = queue.poll();
				depth[now] = d;

				for (int next : tree[now]) {
					if (!visited[next]) {
						parent[next] = now;
						visited[next] = true;
						queue.add(next);
					}
				}
			}

			d++;
		}
	}

	private static int LCA(int a, int b) {
		if (depth[a] < depth[b]) {
			int temp = a;
			a = b;
			b = temp;
		}

		while (depth[a] > depth[b]) {
			a = parent[a];
		}

		while (a != b) {
			a = parent[a];
			b = parent[b];
		}

		return a;
	}
}
