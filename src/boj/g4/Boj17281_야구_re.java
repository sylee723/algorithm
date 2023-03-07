package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj17281_야구_re {
	static int N, maxScore;
	static int[][] playResult;
	static int[] playerOrder;
	static boolean[] used;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		playResult = new int[N][10];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				playResult[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		playerOrder = new int[10];
		playerOrder[4] = 1;
		used = new boolean[10];
		used[1] = true;
		maxScore = 0;
		setPlayerOrder(1);

		System.out.println(maxScore);
	}

	private static void setPlayerOrder(int idx) { // 타순 결정
		if (idx == 4) {
			setPlayerOrder(idx + 1);
			return;
		}

		if (idx == 10) { // 1번 타자 ~ 9번 타자 결정됨
			play();
			return;
		}

		for (int i = 1; i <= 9; i++) {
			if (used[i])
				continue;

			playerOrder[idx] = i;
			used[i] = true;
			setPlayerOrder(idx + 1);
			used[i] = false;
		}
	}

	private static void play() { // 득점 계산
		int pNum = 1; // 1번 타자부터 시작
		int player; // 몇번 선수인지
		int outCnt;
		int[] base;
		int score = 0;

		for (int inning = 0; inning < N; inning++) {
			outCnt = 0; // 이닝이 시작되면 out 0
			base = new int[4]; // 이닝이 시작될 때 주자 없음

			while (outCnt < 3) {
				player = playerOrder[pNum];

				switch (playResult[inning][player]) {
				case 1: // 안타
					score += base[3];
					base[3] = base[2];
					base[2] = base[1];
					base[1] = 1;
					break;
				case 2: // 2루타
					score += (base[3] + base[2]);
					base[3] = base[1];
					base[2] = 1;
					base[1] = 0;
					break;
				case 3: // 3루타
					score += (base[3] + base[2] + base[1]);
					base[3] = 1;
					base[2] = 0;
					base[1] = 0;
					break;
				case 4: // 홈런
					score += (base[3] + base[2] + base[1] + 1);
					base[3] = 0;
					base[2] = 0;
					base[1] = 0;
					break;
				case 0: // 아웃
					outCnt++;
					break;
				}

				pNum += 1;
				if (pNum == 10)
					pNum = 1;
			}
		}

		maxScore = Math.max(maxScore, score);
	}
}
