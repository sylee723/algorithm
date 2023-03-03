package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj13023_ABCDE {
	static int N, answer;
	static ArrayList<Integer>[] friendList;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		friendList = new ArrayList[N];
		for (int n = 0; n < N; n++) {
			friendList[n] = new ArrayList<Integer>();
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friendList[a].add(b);
			friendList[b].add(a);
		}

		answer = 0;
		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			dfs(i, 0);
		}
		
		if (answer >= 4)
			System.out.println(1);
		else
			System.out.println(0);
	}

	private static void dfs(int v, int link) {
		answer = Math.max(answer, link);
		if (answer >= 4)
			return;
		
		visited[v] = true;
		for (int f : friendList[v]) {
			if (!visited[f]) {
				visited[f] = true;
				dfs(f, link + 1);
			}
		}
		visited[v] = false;
	}
}
