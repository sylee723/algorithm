package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1504_특정한_최단_경로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[][] graph = new int[N + 1][N + 1];

		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph[a][b] = c;
			graph[b][a] = c;
		}

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if (i == k)
					continue;
				for (int j = 1; j <= N; j++) {
					if (j == k || i == j)
						continue;

					if (graph[i][k] == 0 || graph[k][j] == 0) {
						continue;
					}

					if (graph[i][j] == 0 || graph[i][j] > graph[i][k] + graph[k][j]) {
						graph[i][j] = graph[i][k] + graph[k][j];
					}
				}
			}
		}

		int route1 = graph[1][v1] + graph[v1][v2] + graph[v2][N];
		if ((graph[1][v1] == 0 && v1 != 1) || graph[v1][v2] == 0 || (graph[v2][N] == 0 && v2 != N)) {
			route1 = -1;
		}

		int route2 = graph[1][v2] + graph[v2][v1] + graph[v1][N];
		if ((graph[1][v2] == 0 && v2 != 1) || graph[v2][v1] == 0 || (graph[v1][N] == 0 && v1 != N)) {
			route2 = -1;
		}

		if (route1 == -1 && route2 == -1) {
			System.out.println(-1);
		} else if (route1 == -1) {
			System.out.println(route2);
		} else if (route2 == -1) {
			System.out.println(route1);
		} else {
			System.out.println(Math.min(route1, route2));
		}
	}
}
