package boj.g2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Boj17825_주사위_윷놀이 {
	static int[] dice;
	static int maxScore;
	static int[][] horse;
	static ArrayList<Integer>[] route;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		dice = new int[10];
		for (int i = 0; i < dice.length; i++) {
			dice[i] = sc.nextInt();
		}
		maxScore = 0;
		initRoute();

		horse = new int[4][2];
		game(0, 0);

		System.out.println(maxScore);
	}

	private static void initRoute() {
		route = new ArrayList[4];

		route[0] = new ArrayList<>();
		for (int i = 0; i <= 20; i++) {
			route[0].add(i * 2);
		}
		route[1] = new ArrayList<>(Arrays.asList(13, 16, 19, 25, 30, 35, 40));
		route[2] = new ArrayList<>(Arrays.asList(22, 24, 25, 30, 35, 40));
		route[3] = new ArrayList<>(Arrays.asList(28, 27, 26, 25, 30, 35, 40));
	}

	private static void game(int turn, int score) {
		if (turn == 10) {
			maxScore = Math.max(maxScore, score);
			return;
		}

		int move = dice[turn];

		for (int h = 0; h < 4; h++) {
			int rNum = horse[h][0];
			int point = horse[h][1];

			// 도착한 칸에 있는 말은 이동하지 않음
			if (route[rNum].size() <= point) {
				continue;
			}

			int nextRNum = rNum;
			int nextPoint = point;
			if (rNum == 0 && (point == 5 || point == 10 || point == 15)) {
				nextRNum = point / 5;
				nextPoint = -1;
			}

			nextPoint += move;

			boolean visited = false;
			for (int o = 0; o < 4; o++) {
				if (h == o)
					continue;

				if (isSamePoint(nextRNum, nextPoint, horse[o][0], horse[o][1])) {
					visited = true;
					break;
				}
			}

			if (visited) // 이미 같은 칸에 다른 말이 있는 경우 이동하지 않음
				continue;

			horse[h][0] = nextRNum;
			horse[h][1] = nextPoint;

			if (route[horse[h][0]].size() > horse[h][1]) {
				game(turn + 1, score + route[horse[h][0]].get(horse[h][1]));
			} else {
				game(turn + 1, score);
			}

			// 되돌려 놓기
			horse[h][0] = rNum;
			horse[h][1] = point;
		}
	}

	private static boolean isSamePoint(int r1, int p1, int r2, int p2) {
		if (route[r1].size() <= p1 || route[r2].size() <= p2) { // 도착 칸에 도착한 경우
			return false;
		}

		if (r1 == r2 && p1 == p2) {
			return true;
		}

		if (r1 > r2) {
			int t_r1 = r1;
			r1 = r2;
			r2 = t_r1;
			int t_p1 = p1;
			p1 = p2;
			p2 = t_p1;
		}

		switch (r1) {
		case 0:
			if (p1 == route[r1].size() - 1 && p2 == route[r2].size() - 1) {
				return true;
			}
			break;
		case 1:
			if (route[r1].size() - p1 <= 4 && ((r2 == 2 && p2 == p1 - 1) || (r2 == 3 && p2 == p1))) {
				return true;
			}
			break;
		case 2:
			if (route[r1].size() - p1 <= 4 && (r2 == 3 && p2 == p1 + 1)) {
				return true;
			}
			break;
		}

		return false;
	}
}
