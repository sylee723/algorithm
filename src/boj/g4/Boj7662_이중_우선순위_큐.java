package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj7662_이중_우선순위_큐 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		char op;
		int K, n, max, min;
		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < T; t++) {
			K = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> minQ = new PriorityQueue<>();
			PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());

			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				op = st.nextToken().charAt(0);
				n = Integer.parseInt(st.nextToken());

				if (op == 'I') { // 삽입
					minQ.add(n);
					maxQ.add(n);
				} else if (op == 'D' && !minQ.isEmpty()) {
					if (n == 1) { // 최댓값 삭제
						max = maxQ.poll();
						minQ.remove(max);
					} else if (n == -1) { // 최솟값 삭제
						min = minQ.poll();
						maxQ.remove(min);
					}
				}
			}

			if (minQ.isEmpty()) {
				sb.append("EMPTY").append("\n");
			} else {
				sb.append(maxQ.peek()).append(" ").append(minQ.peek()).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
