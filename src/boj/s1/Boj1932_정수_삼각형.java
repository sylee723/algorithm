package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1932_정수_삼각형 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] triangle = new int[n][n];

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] d = new int[n][n];
		d[0][0] = triangle[0][0];
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j <= i; j++) {
				d[i + 1][j] = Math.max(d[i + 1][j], d[i][j] + triangle[i + 1][j]);
				d[i + 1][j + 1] = Math.max(d[i + 1][j + 1], d[i][j] + triangle[i + 1][j + 1]);
			}
		}

		int answer = 0;
		for (int j = 0; j < n; j++) {
			answer = Math.max(answer, d[n - 1][j]);
		}

		System.out.println(answer);
	}
}
