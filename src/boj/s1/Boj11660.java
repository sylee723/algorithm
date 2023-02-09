package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//구간 합 구하기 5
public class Boj11660 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] sum_row = new int[N + 1][N + 1]; // 행마다 합을 구함

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				sum_row[i][j] = sum_row[i][j - 1] + Integer.parseInt(st.nextToken());
			}
		}
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int result = 0;
			for (int i = x1; i <= x2; i++) {
				result += (sum_row[i][y2] - sum_row[i][y1 - 1]);
			}
			sb.append(result).append("\n");
//			System.out.println(result);
		}
		System.out.println(sb.toString());
	}
}
