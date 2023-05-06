package boj.g2;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Boj1525_퍼즐 {
	static int answer;
	static String goal = "123456780";
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			sb.append(sc.next());
		}
		String board = sb.toString();

		answer = -1;
		bfs(board);
		System.out.println(answer);
	}

	private static void bfs(String start) {
		Queue<String> queue = new ArrayDeque<>();
		Set<String> visited = new HashSet<>();

		visited.add(start);
		queue.add(start);

		int time = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int s = 0; s < size; s++) {
				String now = queue.poll();
				if (now.equals(goal)) {
					answer = time;
					return;
				}

				int zeroIdx = now.indexOf('0');

				int zi = zeroIdx / 3;
				int zj = zeroIdx % 3;
				for (int d = 0; d < 4; d++) {
					int nexti = zi + di[d];
					int nextj = zj + dj[d];
					if (nexti >= 0 && nexti < 3 && nextj >= 0 && nextj < 3) {
						int nextZeroIdx = nexti * 3 + nextj;
						char tmp = now.charAt(nextZeroIdx);
						StringBuilder next = new StringBuilder(now);
						next.setCharAt(zeroIdx, tmp);
						next.setCharAt(nextZeroIdx, '0');

						if (!visited.contains(next.toString())) {
							visited.add(next.toString());
							queue.add(next.toString());
						}
					}
				}
			}
			time++;
		}
	}
}
