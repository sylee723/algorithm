package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj11054_가장_긴_바이토닉_부분_수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		int[] up = new int[N];
		int[] down = new int[N];

		Arrays.fill(up, 1);
		Arrays.fill(down, 1);

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (num[j] < num[i]) {
					up[i] = Math.max(up[i], up[j] + 1);
				}
			}
		}

		for (int i = N - 2; i >= 0; i--) {
			for (int j = N - 1; j > i; j--) {
				if (num[j] < num[i]) {
					down[i] = Math.max(down[i], down[j] + 1);
				}
			}
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			answer = Math.max(answer, up[i] + down[i] - 1);
		}

		System.out.println(answer);
	}
}
