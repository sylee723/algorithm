import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] item;
	static ArrayList<Area>[] adjList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		item = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			item[i] = Integer.parseInt(st.nextToken());
			adjList[i] = new ArrayList<>();
		}

		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());

			adjList[a].add(new Area(b, l));
			adjList[b].add(new Area(a, l));
		}

		int maxCnt = 0;
		for (int start = 1; start <= N; start++) {
			int count = bfs(N, M, start);
			maxCnt = Math.max(maxCnt, count);
		}

		System.out.println(maxCnt);
	}

	private static int bfs(int N, int M, int start) {
		Queue<Area> queue = new ArrayDeque<>();
		int[] visited = new int[N + 1];

		Arrays.fill(visited, M + 1);
		visited[start] = 0;
		queue.add(new Area(start, 0));

		while (!queue.isEmpty()) {
			Area now = queue.poll();

			for (Area next : adjList[now.num]) {
				if (now.len + next.len < visited[next.num]) {
					visited[next.num] = now.len + next.len;
					queue.add(new Area(next.num, now.len + next.len));
				}
			}
		}

		int itemCnt = 0;
		for (int i = 1; i <= N; i++) {
			if (visited[i] <= M) {
				itemCnt += item[i];
			}
		}

		return itemCnt;
	}

	static class Area {
		int num, len;

		public Area(int num, int len) {
			this.num = num;
			this.len = len;
		}
	}
}