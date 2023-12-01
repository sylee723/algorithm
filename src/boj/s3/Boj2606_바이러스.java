package boj.s3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Boj2606_바이러스 {
	static int N;
	static ArrayList<Integer>[] network;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		int M = sc.nextInt();

		network = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			network[i] = new ArrayList<>();
		}

		for (int m = 0; m < M; m++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			network[a].add(b);
			network[b].add(a);
		}

		int answer = bfs();

		System.out.println(answer);
	}

	private static int bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visit = new boolean[N + 1];
		queue.add(1);
		visit[1] = true;

		int count = 0;
		while (!queue.isEmpty()) {
			int now = queue.poll();
			if (now != 1)
				count++;

			for (int i = 0; i < network[now].size(); i++) {
				int next = network[now].get(i);

				if (!visit[next]) {
					visit[next] = true;
					queue.add(next);
				}
			}
		}

		return count;
	}
}
