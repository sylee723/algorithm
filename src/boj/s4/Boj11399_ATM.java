package boj.s4;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj11399_ATM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < N; i++) {
			pq.add(sc.nextInt());
		}

		int answer = 0;
		for (int n = N; n >= 1; n--) {
			int time = pq.poll();
			answer += time * n;
		}
		System.out.println(answer);
	}
}
