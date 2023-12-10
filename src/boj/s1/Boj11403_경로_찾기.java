package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj11403_경로_찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] adjList = new ArrayList[N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			adjList[i] = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					adjList[i].add(j);
				}
			}
		}

		int[][] adjArr = new int[N][N];
		Queue<Integer> queue = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			for (int node : adjList[i]) {
				queue.add(node);
				adjArr[i][node] = 1;
			}

			while (!queue.isEmpty()) {
				int now = queue.poll();

				for (int next : adjList[now]) {
					if (adjArr[i][next] != 1) {
						queue.add(next);
						adjArr[i][next] = 1;
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(adjArr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
