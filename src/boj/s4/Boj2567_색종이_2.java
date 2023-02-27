package boj.s4;

import java.util.Scanner;

public class Boj2567_색종이_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] black = new int[101][101]; // 흰 도화지에서 검은색종이가 놓인 위치를 표현하는 배열
		for (int n = 0; n < N; n++) {
			int si = sc.nextInt();
			int sj = sc.nextInt();

			for (int i = si; i < si + 10; i++) {
				for (int j = sj; j < sj + 10; j++) {
					black[i][j] = 1; // 검은 부분이면 1, 아니면 0
				}
			}
		} // end input

		int totalLen = 0; // 전체 검은 둘레의 길이
		int[] di = { -1, 1, 0, 0 }; // 상, 하, 좌, 우 탐색을 위한 델타 배열
		int[] dj = { 0, 0, -1, 1 };
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				int len = 0; // 넓이 1인 검은 부분 칸의 둘레의 길이

				if (black[i][j] == 1) { // 검은색 스카프 있는 부분
					for (int d = 0; d < 4; d++) {
						int nexti = i + di[d];
						int nextj = j + dj[d];

						// 현재 (검은)칸의 상하좌우가 비어있으면 길이 1인 모서리 개수 len을 1 증가시킴
						// 배열의 크기를 101 x 101로 하여 100행, 100열을 빈칸으로 채워서 99행, 99열에 검은 부분이 있는 경우도 동일하게 처리함
						if (nexti >= 0 && nexti <= 100 && nextj >= 0 && nextj <= 100 && black[nexti][nextj] == 0) { // 네 변 중 가장가리에 속하는 변을 더함
							len++;
						}
					}
				}
				totalLen += len; // 전체 둘레의 길이
			}
		}
		
		System.out.println(totalLen);
	}
}
