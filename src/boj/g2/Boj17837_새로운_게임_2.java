package boj.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj17837_새로운_게임_2 {
	static int[][] board;
	static Chess[] chessInfo;
	static ArrayList<Integer>[][] chessBoard;
	static int[] di = { 0, 0, 0, -1, 1 };
	static int[] dj = { 0, 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		chessInfo = new Chess[K + 1];
		chessBoard = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				chessBoard[i][j] = new ArrayList<>();
			}
		}

		for (int k = 1; k <= K; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());

			chessInfo[k] = new Chess(i - 1, j - 1, dir);
			chessBoard[i - 1][j - 1].add(k);
		}

		int turn = 1;
		while (true) {
			if (turn > 1000) {
				turn = -1;
				break;
			}

			boolean gameOver = false;
			for (int k = 1; k <= K; k++) {
				if (!moveChess(k)) {
					gameOver = true;
					break;
				}
			}

			if (gameOver) {
				break;
			}

			turn++;
		}

		System.out.println(turn);
	}

	private static boolean moveChess(int num) {
		Chess now = chessInfo[num];
		int nexti = now.i + di[now.dir];
		int nextj = now.j + dj[now.dir];

		if (nexti < 0 || nexti >= board.length || nextj < 0 || nextj >= board.length || board[nexti][nextj] == 2) {
			now.dir = getOpposite(now.dir);
			nexti = now.i + di[now.dir];
			nextj = now.j + dj[now.dir];

			if (nexti < 0 || nexti >= board.length || nextj < 0 || nextj >= board.length || board[nexti][nextj] == 2) {
				return true;
			}
		}

		// 흰색, 빨간색인 경우
		ArrayList<Integer> moveNum = new ArrayList<>();
		boolean move = false;
		for (int cNum : chessBoard[now.i][now.j]) {
			if (cNum == num) {
				move = true;
			}

			if (move) {
				moveNum.add(cNum);
			}
		}

		for (int s = 0; s < moveNum.size(); s++) {
			chessBoard[now.i][now.j].remove(chessBoard[now.i][now.j].size() - 1); // 현재 칸에서 말 지우기
		}

		// 새로운 칸으로 말 이동
		if (board[nexti][nextj] == 0) { // 흰색
			for (int k = 0; k < moveNum.size(); k++) {
				int cNum = moveNum.get(k);
				chessBoard[nexti][nextj].add(cNum);
				chessInfo[cNum].i = nexti;
				chessInfo[cNum].j = nextj;
			}
		} else if (board[nexti][nextj] == 1) { // 빨간색
			for (int k = moveNum.size() - 1; k >= 0; k--) {
				int cNum = moveNum.get(k);
				chessBoard[nexti][nextj].add(cNum);
				chessInfo[cNum].i = nexti;
				chessInfo[cNum].j = nextj;
			}
		}

		if (chessBoard[nexti][nextj].size() >= 4) {
			return false;
		} else {
			return true;
		}
	}

	private static int getOpposite(int dir) {
		switch (dir) {
		case 1:
			return 2;
		case 2:
			return 1;
		case 3:
			return 4;
		case 4:
			return 3;
		}

		return -1;
	}

	static class Chess {
		int i, j, dir;

		public Chess(int i, int j, int dir) {
			this.i = i;
			this.j = j;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Chess [i=" + i + ", j=" + j + ", dir=" + dir + "]";
		}
	}
}
