package boj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj20125_쿠키의_신체_측정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] cookie = new char[N + 1][N + 1];
		boolean heart = false;
		int hi = 0;
		int hj = 0;

		for (int i = 1; i <= N; i++) {
			String line = br.readLine();
			for (int j = 1; j <= N; j++) {
				cookie[i][j] = line.charAt(j - 1);
				if (!heart && cookie[i][j] == '*') {
					hi = i + 1;
					hj = j;
					heart = true;
				}
			}
		}

		int[] len = new int[5];
		for (int j = 1; j <= N; j++) {
			if (j < hj && cookie[hi][j] == '*') {
				len[0]++;
			}
			if (j > hj && cookie[hi][j] == '*') {
				len[1]++;
			}
		}

		for (int i = hi + 1; i <= N; i++) {
			if (cookie[i][hj] == '*') {
				len[2]++;
			}
			if (cookie[i][hj - 1] == '*') {
				len[3]++;
			}
			if (cookie[i][hj + 1] == '*') {
				len[4]++;
			}
		}

		System.out.println(hi + " " + hj);
		for (int i = 0; i < 5; i++) {
			System.out.print(len[i] + " ");
		}
	}
}
