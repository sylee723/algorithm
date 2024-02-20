package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj9465_스티커 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] score = new int[N + 1][2];

			for (int j = 0; j < 2; j++) {
				st = new StringTokenizer(br.readLine());
				for (int i = 1; i <= N; i++) {
					score[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] d = new int[N + 1][2];
			d[1][0] = score[1][0];
			d[1][1] = score[1][1];

			for (int i = 2; i <= N; i++) {
				d[i][0] = Math.max(d[i - 1][1], d[i - 2][1]) + score[i][0];
				d[i][1] = Math.max(d[i - 1][0], d[i - 2][0]) + score[i][1];
			}

			System.out.println(Math.max(d[N][0], d[N][1]));
		}
	}
}
