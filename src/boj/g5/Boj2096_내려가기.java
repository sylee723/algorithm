package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2096_내려가기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] num = new int[N][3];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] maxScore = new int[N][3];
		maxScore[0][0] = num[0][0];
		maxScore[0][1] = num[0][1];
		maxScore[0][2] = num[0][2];

		int[][] minScore = new int[N][3];
		minScore[0][0] = num[0][0];
		minScore[0][1] = num[0][1];
		minScore[0][2] = num[0][2];

		for (int i = 1; i < N; i++) {
			maxScore[i][0] = Math.max(maxScore[i - 1][0], maxScore[i - 1][1]) + num[i][0];
			minScore[i][0] = Math.min(minScore[i - 1][0], minScore[i - 1][1]) + num[i][0];

			maxScore[i][1] = Math.max(maxScore[i - 1][0], maxScore[i - 1][1]);
			maxScore[i][1] = Math.max(maxScore[i][1], maxScore[i - 1][2]);
			maxScore[i][1] += num[i][1];
			minScore[i][1] = Math.min(minScore[i - 1][0], minScore[i - 1][1]);
			minScore[i][1] = Math.min(minScore[i][1], minScore[i - 1][2]);
			minScore[i][1] += num[i][1];

			maxScore[i][2] = Math.max(maxScore[i - 1][1], maxScore[i - 1][2]) + num[i][2];
			minScore[i][2] = Math.min(minScore[i - 1][1], minScore[i - 1][2]) + num[i][2];
		}

		int max = Math.max(maxScore[N - 1][0], maxScore[N - 1][1]);
		max = Math.max(max, maxScore[N - 1][2]);

		int min = Math.min(minScore[N - 1][0], minScore[N - 1][1]);
		min = Math.min(min, minScore[N - 1][2]);

		System.out.println(max + " " + min);
	}
}
