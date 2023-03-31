package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1149_RGB거리 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] RGB = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				RGB[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// D[x][y] : x번째 집을 y번째 색(R:0, G:1, B:2)으로 칠할 때 드는 최소 비용
		int[][] D = new int[N][3];
		for (int j = 0; j < 3; j++) {
			D[0][j] = RGB[0][j];
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				D[i][j] = Integer.MAX_VALUE;
				for (int c = 0; c < 3; c++) {
					if (c == j)
						continue;
					D[i][j] = Math.min(D[i][j], D[i - 1][c] + RGB[i][j]);
				}
			}
		}

		int answer = Math.min(D[N - 1][0], D[N - 1][1]);
		answer = Math.min(answer, D[N - 1][2]);
		System.out.println(answer);
	}
}
