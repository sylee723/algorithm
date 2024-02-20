package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1753_최단경로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int K = Integer.parseInt(br.readLine());
		List<Node>[] graph = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<Node>();
		}

		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			int size = graph[u].size();

			graph[u].add(new Node(v, w));
		}

		int[] distance = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			distance[i] = Integer.MAX_VALUE;
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		boolean[] visited = new boolean[V + 1];
		visited[K] = true;
		int visitCnt = 1;
		distance[K] = 0;
		for (Node node : graph[K]) {
			distance[node.num] = Math.min(distance[node.num], node.weight);
			pq.add(new int[] { node.num, distance[node.num] });
		}

		while (!pq.isEmpty() && visitCnt < V) {
			int[] now = pq.poll();
			int minIdx = now[0];
			int min = distance[minIdx];

			if (visited[minIdx])
				continue;

			visitCnt++;
			visited[minIdx] = true;

			for (Node node : graph[minIdx]) {
				if (distance[node.num] > min + node.weight) {
					distance[node.num] = min + node.weight;
					pq.add(new int[] { node.num, distance[node.num] });
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			if (distance[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			} else {
				sb.append(distance[i]).append("\n");
			}
		}

		System.out.println(sb.toString());
	}

	static class Node {
		int num, weight;

		public Node(int num, int weight) {
			this.num = num;
			this.weight = weight;
		}
	}
}
