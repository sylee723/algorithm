package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj14499_주사위_굴리기 {
	static int[] di = { 0, 0, -1, 1 }; // 동, 서, 북, 남
	static int[] dj = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int ni = Integer.parseInt(st.nextToken());
		int nj = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int bottom = 1;
		int top = getTop(bottom);
		int[] diceNum = new int[7];

		int[] dice = { 3, 4, 2, 5 }; // 동, 서, 북, 남

		st = new StringTokenizer(br.readLine());
		for (int k = 0; k < K; k++) {
			int d = Integer.parseInt(st.nextToken()) - 1;

			int nexti = ni + di[d];
			int nextj = nj + dj[d];

			if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= M) {
				continue;
			}

			int nextBottom = dice[d];
			if (map[nexti][nextj] == 0) {
				map[nexti][nextj] = diceNum[nextBottom];
			} else {
				diceNum[nextBottom] = map[nexti][nextj];
				map[nexti][nextj] = 0;
			}
			dice = getNextDice(bottom, nextBottom, dice, d);
			ni = nexti;
			nj = nextj;
			bottom = nextBottom;
			top = getTop(nextBottom);

			System.out.println(diceNum[top]);
		}
	}

	private static int[] getNextDice(int n, int nextBottom, int[] dice, int d) {

		int[] nextDice = new int[4];
		int dir = getOppositeDir(d);
		nextDice[dir] = n;

		ArrayList<Integer> temp = new ArrayList<>();
		switch (nextBottom) {
		case 1:
			temp.add(2);
			temp.add(3);
			temp.add(5);
			temp.add(4);
			break;
		case 2:
			temp.add(1);
			temp.add(4);
			temp.add(6);
			temp.add(3);
			break;
		case 3:
			temp.add(1);
			temp.add(2);
			temp.add(6);
			temp.add(5);
			break;
		case 4:
			temp.add(1);
			temp.add(5);
			temp.add(6);
			temp.add(2);
			break;
		case 5:
			temp.add(1);
			temp.add(3);
			temp.add(6);
			temp.add(4);
			break;
		case 6:
			temp.add(2);
			temp.add(4);
			temp.add(5);
			temp.add(3);
			break;
		}

		switch (dir) {
		case 0:
			dir = 1;
			break;
		case 1:
			dir = 3;
			break;
		case 2:
			dir = 0;
			break;
		case 3:
			dir = 2;
			break;
		}

		for (int t = 0; t < 4; t++) {
			if (temp.get(dir) == n)
				break;
			int x = temp.remove(0);
			temp.add(x);
		}

		nextDice[2] = temp.remove(0);
		nextDice[0] = temp.remove(0);
		nextDice[3] = temp.remove(0);
		nextDice[1] = temp.remove(0);

		return nextDice;
	}

	private static int getOppositeDir(int d) {
		switch (d) {
		case 0:
			return 1;
		case 1:
			return 0;
		case 2:
			return 3;
		case 3:
			return 2;
		}
		return -1;
	}

	private static int getTop(int bottom) {
		switch (bottom) {
		case 1:
			return 6;
		case 2:
			return 5;
		case 3:
			return 4;
		case 4:
			return 3;
		case 5:
			return 2;
		case 6:
			return 1;
		}
		return 0;
	}
}
