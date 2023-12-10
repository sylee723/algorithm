package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj11279_최대_힙 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int x;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			x = Integer.parseInt(br.readLine());

			if (x == 0) {
				if (pq.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append((-1) * pq.poll()).append("\n");
				}
			} else {
				pq.add((-1) * x);
			}
		}

		System.out.println(sb.toString());
	}
}
