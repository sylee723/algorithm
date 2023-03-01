package boj.g5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj1068_트리_인접리스트 {
	static int N;
	static ArrayList<Integer>[] tree;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		tree = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			tree[i] = new ArrayList<>();
		}

		int root = -1;
		for (int i = 0; i < N; i++) {
			int parent = sc.nextInt();
			if (parent == -1) {
				root = i;
				continue;
			}

			tree[parent].add(i);
		}

		int r = sc.nextInt();
		removeNode(r);
		if (r == root)
			root = -1;

		int leafCnt = 0;
		if (root >= 0) {
			Queue<Integer> queue = new LinkedList<>();
			boolean[] visited = new boolean[N];

			visited[root] = true;
			queue.add(root);

			while (!queue.isEmpty()) {
				int now = queue.poll();
				if (tree[now].size() == 0)
					leafCnt++;

				for (int i = 0; i < tree[now].size(); i++) {
					int next = tree[now].get(i);
					if (!visited[next]) {
						visited[next] = true;
						queue.add(next);
					}
				}
			}

		}

		System.out.println(leafCnt);
	}

	static void removeNode(int r) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < tree[i].size(); j++) {
				if (tree[i].get(j) == r)
					tree[i].remove(j);
			}
		}
		for (int i = 0; i < tree[r].size(); i++) {
			removeNode(tree[r].get(i));
		}
		tree[r] = new ArrayList<>();
	}
}
