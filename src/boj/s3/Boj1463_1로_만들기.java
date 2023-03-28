package boj.s3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj1463_1로_만들기 {
	static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

//		System.out.println(bfs(N));
		boolean[] visited = new boolean[N + 1];
		answer = Integer.MAX_VALUE;
		dfs(N, 0, visited);
		System.out.println(answer);
	}

	private static void dfs(int n, int d, boolean[] visited) {
		System.out.println(n+"/"+d);
		if (n == 1) {
			System.out.println("ans:"+answer);
			answer = Math.min(answer, d);
			return;
		}
		
		if (d >= answer)
			return;
		
		visited[n] = true;

		if (n % 3 == 0 && !visited[n / 3]) {
			dfs(n / 3, d + 1, visited);
			visited[n / 3] = false;
		}
		if (n % 2 == 0 && !visited[n / 2]) {
			dfs(n / 2, d + 1, visited);
			visited[n / 2] = false;
		}
		if (!visited[n - 1]) {
			dfs(n - 1, d + 1, visited);
			visited[n - 1] = false;
		}
	}

	private static int bfs(int n) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[n + 1];
		queue.add(n);
		visited[n] = true;

		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int s = 0; s < size; s++) {
				int now = queue.poll();
				if (now == 1)
					return count;

				if (!visited[now - 1]) {
					queue.add(now - 1);
					visited[now - 1] = true;
				}
				if (now % 2 == 0 && !visited[now / 2]) {
					queue.add(now / 2);
					visited[now / 2] = true;
				}
				if (now % 3 == 0 && !visited[now / 3]) {
					queue.add(now / 3);
					visited[now / 3] = true;
				}
			}
			count++;
		}
		return -1;
	}
}

// DP
//public class Boj1463_1로_만들기 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		int[] memo = new int[N + 1];
//
//		memo[1] = 0;
//		for (int i = 2; i <= N; i++) {
//			memo[i] = memo[i - 1] + 1;
//			if (i % 2 == 0) {
//				memo[i] = Math.min(memo[i / 2] + 1, memo[i]);
//			}
//			if (i % 3 == 0) {
//				memo[i] = Math.min(memo[i / 3] + 1, memo[i]);
//			}
//		}
//		System.out.println(memo[N]);
//	}
//}