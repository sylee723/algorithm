package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Ladder1
public class Swea1210_재귀 {
	static int[][] data;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int tc = Integer.parseInt(br.readLine());
			data = new int[100][100];
			int now = 0;
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					data[i][j] = Integer.parseInt(st.nextToken());
					if (data[i][j] == 2) {
						now = j;
					}
				}
			} // input

			now = goUp(99, now);
			System.out.println("#" + tc + " " + now);
		} // test case
	}

	static int goUp(int i, int j) {
		if (i == 0) // 맨 윗줄이면 출발점 리턴
			return j;
		if (j - 1 >= 0 && data[i][j - 1] == 1) {
			j--;
			while (data[i - 1][j] != 1)
				j--;
		} else if (j + 1 <= 99 && data[i][j + 1] == 1) {
			j++;
			while (data[i - 1][j] != 1) {
				j++;
			}
		}
		return goUp(i - 1, j);
	}
}