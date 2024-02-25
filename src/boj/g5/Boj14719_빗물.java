package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14719_빗물 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		boolean[][] block = new boolean[H][W];
		st = new StringTokenizer(br.readLine());

		for (int j = 0; j < W; j++) {
			int height = Integer.parseInt(st.nextToken());

			for (int i = 0; i < height; i++) {
				block[i][j] = true;
			}
		}

		int answer = 0;
		for (int i = 0; i < H; i++) {
			int j = 0;
			while (j < W && !block[i][j]) {
				j++; // 처음 블록 만날때까지
			}

			while (j < W) {
				while (j < W && block[i][j]) {
					j++;
				}

				int count = 0;
				while (j < W && !block[i][j]) {
					j++;
					count++;
				}
				if (j < W && block[i][j]) {
					answer += count;
				}
			}
		}

		System.out.println(answer);
	}
}
