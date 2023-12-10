package boj.s1;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj11286_절댓값_힙 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Num> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();

			if (x == 0) {
				if (pq.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(pq.poll().x).append("\n");
				}
			} else {
				pq.add(new Num(Math.abs(x), x));
			}
		}

		System.out.println(sb.toString());
	}

	static class Num implements Comparable<Num> {
		int abs;
		int x;

		public Num(int abs, int x) {
			super();
			this.abs = abs;
			this.x = x;
		}

		@Override
		public int compareTo(Num o) {
			if (this.abs == o.abs)
				return this.x - o.x;

			return this.abs - o.abs;
		}
	}
}
