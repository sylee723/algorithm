package boj.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj1167_트리의_지름 {
	static ArrayList<Node>[] adjList;
	static int answer;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int V = Integer.parseInt(br.readLine());
		adjList = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 1; i <= V; i++) {
			st = new StringTokenizer(br.readLine());

			int num = Integer.parseInt(st.nextToken());
			while (true) {
				int a = Integer.parseInt(st.nextToken());

				if (a == -1) {
					break;
				}

				int b = Integer.parseInt(st.nextToken());
				adjList[num].add(new Node(a, b));
			}
		}

		visited = new boolean[V + 1];
		answer = 0;
		visited[1] = true;
		dfs(1);

		System.out.println(answer);
	}

	private static int dfs(int num) {
		ArrayList<Integer> wList = new ArrayList<>();
		for (Node child : adjList[num]) {
			if (visited[child.num]) {
				continue;
			}

			visited[child.num] = true;
			int wSum = dfs(child.num) + child.weight;
			wList.add(wSum);
		}

		if (wList.size() == 0) {
			return 0;
		} else if (wList.size() == 1) {
			answer = Math.max(answer, wList.get(0));
		} else {
			Collections.sort(wList, Comparator.reverseOrder());
			answer = Math.max(answer, wList.get(0) + wList.get(1));
		}

		return wList.get(0);
	}

	static class Node {
		int num, weight;

		public Node(int num, int weight) {
			this.num = num;
			this.weight = weight;
		}
	}
}
