package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea2001_파리퇴치 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] board = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int max = -1;
			for (int si = 0; si <= N - M; si++) {
				for (int sj = 0; sj <= N - M; sj++) {
					int count = 0;
					for (int i = 0; i < M; i++) {
						for (int j = 0; j < M; j++) {
							count += board[si + i][sj + j];
						}
					}
					max = Math.max(max, count);
				}
			}
			System.out.println("#" + t + " " + max);
		}
	}
}
