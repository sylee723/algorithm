package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj18353_병사_배치하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] power = new int[N];
		for (int i = 0; i < N; i++) {
			power[i] = Integer.parseInt(st.nextToken());
		}

		int[] d = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			d[i] = 1;
			for (int j = 0; j < i; j++) {
				if (power[j] > power[i]) {
					d[i] = Math.max(d[i], d[j] + 1);
				}
			}
			max = Math.max(max, d[i]);
		}

		System.out.println(N - max);
	}
}
