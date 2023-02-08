package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//구간 합 구하기 4
public class Boj11659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] number = new int[N + 1];
		int[] sum_0_to_idx = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
			sum_0_to_idx[i] = sum_0_to_idx[i - 1] + number[i];
		}

		for (int t = 0; t < M; t++) {
			st = new StringTokenizer(br.readLine());
			int si = Integer.parseInt(st.nextToken());
			int ei = Integer.parseInt(st.nextToken());

			System.out.println(sum_0_to_idx[ei] - sum_0_to_idx[si - 1]);
		}
	}
}
