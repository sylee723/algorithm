package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1992_쿼드트리_re {
	static char[][] input;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		input = new char[N][N];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				input[i][j] = line.charAt(j);
			}
		}

		compression(0, 0, N, N);
		System.out.println(sb.toString());
	}

	private static void compression(int si, int sj, int ei, int ej) {
		int count0 = 0;
		for (int i = si; i < ei; i++) {
			for (int j = sj; j < ej; j++) {
				if (input[i][j] == '0') {
					count0++;
				}
			}
		}
		if (count0 == (ei - si) * (ej - sj)) {
			sb.append(0);
		} else if (count0 == 0) {
			sb.append(1);
		} else {
			int mi = (si + ei) / 2;
			int mj = (sj + ej) / 2;
			sb.append("(");
			compression(si, sj, mi, mj);
			compression(si, mj, mi, ej);
			compression(mi, sj, ei, mj);
			compression(mi, mj, ei, ej);
			sb.append(")");
		}
	}
}
