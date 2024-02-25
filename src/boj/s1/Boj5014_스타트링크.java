package boj.s1;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Boj5014_스타트링크 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int F = sc.nextInt();
		int S = sc.nextInt();
		int G = sc.nextInt();
		int U = sc.nextInt();
		int D = sc.nextInt();

		boolean[] visited = new boolean[F + 1];
		Queue<Integer> queue = new ArrayDeque<>();

		visited[S] = true;
		queue.add(S);

		int count = 0;
		int answer = -1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				int now = queue.poll();
				if (now == G) {
					answer = count;
					break;
				}

				int next = now + U;
				if (next <= F && !visited[next]) {
					visited[next] = true;
					queue.add(next);
				}

				next = now - D;
				if (next >= 1 && !visited[next]) {
					visited[next] = true;
					queue.add(next);
				}
			}

			if (answer != -1)
				break;

			count++;
		}

		if (answer != -1) {
			System.out.println(answer);
		} else {
			System.out.println("use the stairs");
		}
	}
}
