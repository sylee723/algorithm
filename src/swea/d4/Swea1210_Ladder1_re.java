package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea1210_Ladder1_re {
	static int[] di = { 0, 0, -1 }; // 우선순위: 좌, 우 > 위
	static int[] dj = { 1, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for (int t = 1; t <= 10; t++) {
			br.readLine();
			int[][] board = new int[100][100];
			int nowi = 0;
			int nowj = 0;
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if (board[i][j] == 2) {
						nowi = i;
						nowj = j;
					}
				}
			}
			while (true) {
				if (nowi == 0)
					break;
				board[nowi][nowj] = -1; // 지나간 길 체크
				for (int d = 0; d < di.length; d++) {
					int nexti = nowi + di[d];
					int nextj = nowj + dj[d];
					if (nextj >= 0 && nextj < 100 && board[nexti][nextj] == 1) {
						nowi = nexti;
						nowj = nextj;
						break;
					}
				}
			}

			System.out.println("#" + t + " " + nowj);
//			for (int i = 0; i < 100; i++) {
//				for (int j = 0; j < 100; j++) {
//					System.out.print(board[i][j] == -1 ? "■" : board[i][j]);
//				}
//				System.out.println();
//			}
		}
	}
}