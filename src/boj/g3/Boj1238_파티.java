package boj.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1238_파티 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		ArrayList<Node>[] adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			adjList[start].add(new Node(end, time));
		}

		int[][] d = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			d[i] = Dijkstra(N, i, adjList);
		}

		int answer = 0;
		for (int i = 1; i <= N; i++) {
			if (i == X)
				continue;

			answer = Math.max(answer, d[i][X] + d[X][i]);
		}

//		int[] distance = Dijkstra(N, X, adjList);
//
//		int answer = 0;
//		for (int i = 1; i <= N; i++) {
//			if (i == X) {
//				continue;
//			}
//			answer = Math.max(answer, distance[i] + bfs(i, X, adjList));
//		}

		System.out.println(answer);
	}

	private static int[] Dijkstra(int N, int X, ArrayList<Node>[] adjList) {
		int[] distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);

		distance[X] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();

		for (Node node : adjList[X]) {
			distance[node.num] = node.time;
			pq.add(node);
		}

		int leftCnt = N - 1;
		boolean[] visited = new boolean[N + 1];

		while (leftCnt > 0 && !pq.isEmpty()) {
			Node now = pq.poll();

			if (visited[now.num]) {
				continue;
			}

			visited[now.num] = true;
			leftCnt--;
			for (Node next : adjList[now.num]) {
				if (distance[next.num] > distance[now.num] + next.time) {
					distance[next.num] = distance[now.num] + next.time;
					pq.add(new Node(next.num, distance[next.num]));
				}
			}
		}

		return distance;
	}

//	private static int bfs(int start, int end, ArrayList<Node>[] adjList) {
//		Queue<Node> queue = new ArrayDeque<>();
//		int[] visited = new int[adjList.length];
//		Arrays.fill(visited, Integer.MAX_VALUE);
//		queue.add(new Node(start, 0));
//		visited[start] = 0;
//
//		int time = Integer.MAX_VALUE;
//		while (!queue.isEmpty()) {
//			Node now = queue.poll();
//			if (now.num == end) {
//				time = Math.min(time, now.time);
//				continue;
//			}
//
//			for (Node next : adjList[now.num]) {
//				if (visited[next.num] > now.time + next.time) {
//					visited[next.num] = now.time + next.time;
//					queue.add(new Node(next.num, now.time + next.time));
//				}
//			}
//		}
//
//		return time;
//	}

	static class Node implements Comparable<Node> {
		int num, time;

		public Node(int num, int time) {
			this.num = num;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			if (this.time == o.time) {
				return this.num - o.num;
			} else {
				return this.time - o.time;
			}
		}
	}
}
