package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1992_쿼드트리 {
	static int[][] input;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		input = new int[N][N];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				input[i][j] = line.charAt(j) - '0';
			}
		}
		System.out.println(compression(0, 0, N));
	}

	static String compression(int si, int sj, int n) {
		int result = 3;
		if (checkDot(si, sj, n))
			result = input[si][sj];
		else {
			checkDot(si, sj, n / 2);
			checkDot(si, sj + n / 2, n / 2);
			checkDot(si + n / 2, sj, n / 2);
			checkDot(si + n / 2, sj + n / 2, n / 2);
		}
		return "(" + Integer.toString(result) + ")";
	}

	static boolean checkDot(int si, int sj, int n) {
		int dot = input[si][sj];
		for (int i = si; i < si + n; i++) {
			for (int j = sj; j < sj + n; j++) {
				if (dot != input[i][j])
					return false;
			}
		}
		return true;
	}
}
