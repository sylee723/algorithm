package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1912_연속합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] d = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());

		d[0] = 0;
		int answer = -2000;
		int min = d[0];
		for (int i = 1; i <= N; i++) {
			d[i] = d[i - 1] + Integer.parseInt(st.nextToken());

			answer = Math.max(answer, d[i] - min);
			if (min > d[i]) {
				min = d[i];
			}
		}

		System.out.println(answer);
	}
}
