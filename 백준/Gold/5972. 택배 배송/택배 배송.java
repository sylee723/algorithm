import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Node>[] adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			adjList[a].add(new Node(b, c));
			adjList[b].add(new Node(a, c));
		}

		int[] distance = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[1] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1, 0));
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (visited[now.num] || now.value != distance[now.num]) {
				continue;
			}

			visited[now.num] = true;
			for (Node next : adjList[now.num]) {
				if (distance[next.num] > distance[now.num] + next.value) {
					distance[next.num] = distance[now.num] + next.value;
					pq.add(new Node(next.num, distance[next.num]));
				}
			}
		}

		System.out.println(distance[N]);
	}

	static class Node implements Comparable<Node> {
		int num, value;

		public Node(int num, int value) {
			this.num = num;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			if (this.value == o.value) {
				return this.num - o.num;
			}
			return this.value - o.value;
		}
	}
}