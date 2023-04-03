package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 해결 못함
public class Boj1806_부분합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] num = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 0;
		int total = 0;
		int answer = Integer.MAX_VALUE;

		while (start < N && end < N) {
			if (total >= S) {
				answer = Math.min(end - start, answer);
				total -= num[start];
				start++;
			} else {
				total += num[end];
				end++;
			}
		}

		if (answer == Integer.MAX_VALUE)
			answer = 0;
		System.out.println(answer);
	}
}
