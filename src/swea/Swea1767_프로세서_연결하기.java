package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Swea1767_프로세서_연결하기 {
	static int N;
	static int[][] board;
	static ArrayList<Point> coreList;
	static int coreCnt, lineLen;
	static int[] coreStatus;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];

			coreList = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if (board[i][j] == 1 && i != 0 && i != N - 1 && j != 0 && j != N - 1) {
						coreList.add(new Point(i, j));
					}
				}
			}

			coreCnt = 0;
			lineLen = Integer.MAX_VALUE;
			coreStatus = new int[coreList.size()];

			setCoreStatus(0, 0, 0);

			System.out.println("#" + tc + " " + lineLen);
		}
	}

	private static void setCoreStatus(int idx, int cnt, int len) {
		if (idx == coreList.size()) {
			if (coreCnt < cnt) {
				coreCnt = cnt;
				lineLen = len;
			} else if (coreCnt == cnt) {
				lineLen = Math.min(lineLen, len);
			}

			return;
		}

		if (coreList.size() - idx + cnt < coreCnt) { // 남은 코어 다 연결해도 코어의 수가 더 적은 경우
			return;
		}

		for (int d = 0; d < 4; d++) {
			int result = setLine(idx, d);
			if (result > 0) {
				coreStatus[idx] = d;
				setCoreStatus(idx + 1, cnt + 1, len + result);
				removeLine(idx, d);
			}
		}

		coreStatus[idx] = -1; // 전원에 연결하지 않음
		setCoreStatus(idx + 1, cnt, len);
	}

	private static void removeLine(int idx, int d) {
		Point core = coreList.get(idx);

		int nowi = core.i;
		int nowj = core.j;

		while (true) {
			int nexti = nowi + di[d];
			int nextj = nowj + dj[d];

			if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= N) {
				break;
			}

			board[nexti][nextj] = 0;
			nowi = nexti;
			nowj = nextj;
		}

	}

	private static int setLine(int idx, int d) {
		Point core = coreList.get(idx);
		int len = 0;

		int nowi = core.i;
		int nowj = core.j;

		while (true) {
			int nexti = nowi + di[d];
			int nextj = nowj + dj[d];

			if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= N) {
				break;
			}

			if (board[nexti][nextj] == 1) { // 전선을 놓을 수 없는 경우
				for (int l = len; l > 0; l--) {
					board[core.i + di[d] * l][core.j + dj[d] * l] = 0; // 이전에 연결한 전선 지우기
				}
				return -1;
			}

			board[nexti][nextj] = 1;
			len++;
			nowi = nexti;
			nowj = nextj;
		}

		return len;
	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}
}
