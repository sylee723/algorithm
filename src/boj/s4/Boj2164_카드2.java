package boj.s4;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Boj2164_카드2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		ArrayDeque<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		int num;
		while (true) {
			if (queue.size() == 1)
				break;
			queue.remove();
			num = queue.getFirst();
			queue.remove();
			queue.add(num);
		}
		System.out.println(queue.getFirst());
	}
}
