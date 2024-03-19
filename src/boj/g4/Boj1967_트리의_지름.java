package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj1967_트리의_지름 {
	static ArrayList<Node>[] adjList;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			adjList[a].add(new Node(b, c));
		}

		answer = 0;
		dfs(1);

		System.out.println(answer);
	}

	private static int dfs(int num) {
		if (adjList[num].size() == 0) {
			return 0;
		}

		ArrayList<Integer> wList = new ArrayList<>();
		for (Node child : adjList[num]) {
			int wSum = dfs(child.num) + child.weight;
			wList.add(wSum);
		}

		if (wList.size() >= 2) {
			Collections.sort(wList, Comparator.reverseOrder());
			answer = Math.max(answer, wList.get(0) + wList.get(1));
		} else {
			answer = Math.max(answer, wList.get(0));
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
