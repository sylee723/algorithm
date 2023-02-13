package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2493_탑 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] tower = new int[N + 1][3]; // 자신 높이, 수신 탑 높이, 수신 탑 인덱스
		StringTokenizer st = new StringTokenizer(br.readLine());
		tower[0][0] = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			tower[i][0] = Integer.parseInt(st.nextToken());
			if (tower[i][0] < tower[i - 1][0]) {
				tower[i][1] = tower[i - 1][0];
				tower[i][2] = i - 1;
			} else {
				int idx = i - 1;
				while (tower[i][0] > tower[idx][1]) {
					idx--;
				}
				tower[i][1] = tower[idx][1];
				tower[i][2] = tower[idx][2];
			}
		}
		for (int i = 1; i <= N; i++) {
			System.out.print(tower[i][2] + " ");
		}
	}
}
