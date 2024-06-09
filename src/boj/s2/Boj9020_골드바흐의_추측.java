package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj9020_골드바흐의_추측 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] isPrimeNum = new boolean[10001];
		Arrays.fill(isPrimeNum, true);

		isPrimeNum[0] = false;
		isPrimeNum[1] = false;
		for (int i = 2; i <= 10000; i++) {
			if (isPrimeNum[i]) {
				int m = 2;
				while (i * m <= 10000) {
					isPrimeNum[i * m] = false;
					m++;
				}
			}
		}

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			int p1 = n / 2;

			while (true) {
				if (isPrimeNum[p1] && isPrimeNum[n - p1]) {
					sb.append(p1).append(" ").append(n - p1).append("\n");
					break;
				}
				p1--;
			}
		}

		System.out.println(sb.toString());
	}
}
