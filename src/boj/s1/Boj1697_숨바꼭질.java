package boj.s1;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Boj1697_숨바꼭질 {
	static int N, K, answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		K = sc.nextInt();
		bfs(N);
		System.out.println(answer);
	}

	private static void bfs(int start) {
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[200001];

		visited[start] = true;
		queue.offer(new int[] { start, 0 }); // 위치, 시간

		int[] current;
		while (!queue.isEmpty()) {
			current = queue.poll();

			if (current[0] == K) {
				answer = current[1];
				break;
			}

			if (current[0] + 1 >= 0 && current[0] + 1 <= 2 * K && !visited[current[0] + 1]) {
				visited[current[0] + 1] = true;
				queue.offer(new int[] { current[0] + 1, current[1] + 1 });
			}
			if (current[0] - 1 >= 0 && current[0] - 1 <= 2 * K && !visited[current[0] - 1]) {
				visited[current[0] - 1] = true;
				queue.offer(new int[] { current[0] - 1, current[1] + 1 });
			}
			if (current[0] * 2 >= 0 && current[0] * 2 <= 2 * K && !visited[current[0] * 2]) {
				visited[current[0] * 2] = true;
				queue.offer(new int[] { current[0] * 2, current[1] + 1 });
			}
		}
	}
}
