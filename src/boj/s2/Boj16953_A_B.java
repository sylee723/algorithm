package boj.s2;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Boj16953_A_B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();

		Queue<Integer> queue = new ArrayDeque<>();
		Set<Integer> visited = new HashSet<>();

		queue.add(A);
		visited.add(A);

		int count = 1;
		int answer = -1;
		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int s = 0; s < size; s++) {
				int now = queue.poll();
				if (now == B) {
					answer = count;
					break;
				}

				long next1 = (long) now * 10 + 1;
				if (!visited.contains(next1) && next1 <= B) {
					visited.add((int) next1);
					queue.add((int) next1);
				}

				long next2 = (long) now * 2;
				if (!visited.contains(next2) && next2 <= B) {
					visited.add((int) next2);
					queue.add((int) next2);
				}
			}

			count++;
		}

		System.out.println(answer);
	}
}
