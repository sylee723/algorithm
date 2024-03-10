package boj.g5;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Boj13549_숨바꼭질_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		Deque<Point> deque = new ArrayDeque<>();
		Set<Integer> visited = new HashSet<>();

		visited.add(N);
		deque.add(new Point(N, 0));

		int answer = Math.abs(N - K);
		while (!deque.isEmpty()) {
			Point now = deque.poll();
			if (now.i == K) {
				answer = now.time;
				break;
			}

			if (now.i * 2 <= 100000 && !visited.contains(now.i * 2)) {
				visited.add(now.i * 2);
				deque.addFirst(new Point(now.i * 2, now.time));
			}

			if (now.i - 1 >= 0 && !visited.contains(now.i - 1)) {
				visited.add(now.i - 1);
				deque.add(new Point(now.i - 1, now.time + 1));
			}

			if (now.i + 1 <= 100000 && !visited.contains(now.i + 1)) {
				visited.add(now.i + 1);
				deque.add(new Point(now.i + 1, now.time + 1));
			}
		}

		System.out.println(answer);
	}

	static class Point {
		int i, time;

		public Point(int i, int time) {
			this.i = i;
			this.time = time;
		}
	}
}
