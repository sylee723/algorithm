package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea4012_요리사 {
	static int N;
	static int[][] S;
	static boolean[] selected;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			S = new int[N][N];
			selected = new boolean[N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					S[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			answer = Integer.MAX_VALUE;
			comb(0, 0);
			System.out.println("#" + t + " " + answer);

		}
	}

	static void comb(int idx, int cnt) {
		if (cnt == N / 2) {
			int foodA = 0;
			int foodB = 0;
			for (int i = 0; i < N; i++) {
				if (selected[i]) {
					for (int j = 0; j < N; j++) {
						if (selected[j]) {
							foodA += S[i][j];
						}
					}
				} else {
					for (int j = 0; j < N; j++) {
						if (!selected[j]) {
							foodB += S[i][j];
						}
					}
				}
			}
			answer = Math.min(answer, Math.abs(foodA - foodB));
			return;
		}

		if (idx == N)
			return;

		selected[idx] = true;
		comb(idx + 1, cnt + 1);
		selected[idx] = false;
		comb(idx + 1, cnt);
	}
}
