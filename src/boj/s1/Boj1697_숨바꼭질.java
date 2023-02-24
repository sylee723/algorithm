package boj.s1;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Boj1697_숨바꼭질 {
	static int N, K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();

		System.out.println(bfs(N));
	}

	private static int bfs(int start) {
		Queue<Point> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[100001];

		visited[start] = true;
		queue.offer(new Point(start, 0)); // 위치, 시간

		Point current;
		while (!queue.isEmpty()) {
			current = queue.poll();

			if (current.num == K) {
				return current.time;
			}

			if (current.num + 1 <= 100000 && !visited[current.num + 1]) {
				visited[current.num + 1] = true;
				queue.offer(new Point(current.num + 1, current.time + 1));
			}
			if (current.num - 1 >= 0 && !visited[current.num - 1]) {
				visited[current.num - 1] = true;
				queue.offer(new Point(current.num - 1, current.time + 1));
			}
			if (current.num * 2 <= 100000 && !visited[current.num * 2]) {
				visited[current.num * 2] = true;
				queue.offer(new Point(current.num * 2, current.time + 1));
			}
		}
		return -1;
	}

	static class Point {
		int num;
		int time;

		public Point(int num, int time) {
			this.num = num;
			this.time = time;
		}
	}
}
