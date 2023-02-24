package boj.g3;

import java.util.Scanner;

public class Boj17135_캐슬_디펜스 {
	static int N, M, D, eCnt, eMaxCnt;
	static int[][] origin, map;
	static boolean[] selected;
	static Point[] target;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();

		origin = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				origin[i][j] = sc.nextInt();
			}
		}

		selected = new boolean[M];
		eMaxCnt = Integer.MIN_VALUE;
		comb(0, 0);

		System.out.println(eMaxCnt);
	}

	private static void comb(int idx, int cnt) { // 궁수 3명 위치 선택
		if (cnt == 3) {
//			for (int i = 0; i < M; i++) {
//				if (selected[i])
//					System.out.print(i + " ");
//			}
//			System.out.println();

			eCnt = 0;
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = origin[i][j]; // 게임을 위해 원본 복사
				}
			}
			game();
//			System.out.println("공격한 적의 수: " + eCnt);
			eMaxCnt = Math.max(eCnt, eMaxCnt);
			return;
		}

		if (idx == M)
			return;

		selected[idx] = true;
		comb(idx + 1, cnt + 1);

		selected[idx] = false;
		comb(idx + 1, cnt);
	}

	private static void game() { // 궁수 3명 배치 결정 후 게임 진행
		boolean gameover = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					gameover = false;
					break;
				}
			}
		}

		if (gameover)
			return; // 남은 적이 없으면 게임 종료

		target = new Point[3];
		int idx = 0;
		for (int c = 0; c < M; c++) {
			if (selected[c]) {
				target[idx] = getEnemy(N, c);
				idx++;
			}
		} // 공격할 적 결정

		nextRound();
		game();
	}

	static Point getEnemy(int nowi, int nowj) { // 가장 가까운 적의 위치를 리턴
		int distance;
		int minDistance = Integer.MAX_VALUE;
		Point ePoint = null;
		for (int ej = 0; ej < M; ej++) { // 왼쪽 열부터 확인
			for (int ei = 0; ei < N; ei++) {
				if (map[ei][ej] == 1) { // 공격 거리 계산
					distance = Math.abs(nowi - ei) + Math.abs(nowj - ej);
					if (distance <= D && distance < minDistance) {
						minDistance = distance;
						ePoint = new Point(ei, ej);
					}
				}
			}
		}
		return ePoint;
	}

	private static void nextRound() {
		// 선택된 적 3명 공격
		for (Point t : target) {
			if (t == null)
				continue;

			if (map[t.i][t.j] == 1) { // 같은 적 카운트 방지
				map[t.i][t.j] = 0; // 공격
				eCnt++;
			}
		}

//		System.out.println("##############################");
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}

		// 적 아래로 한칸 이동
		for (int i = N - 1; i > 0; i--) {
			for (int j = 0; j < M; j++) {
				map[i][j] = map[i - 1][j];
			}
		}
		for (int j = 0; j < M; j++) {
			map[0][j] = 0;
		}
	}

	static class Point {
		int i;
		int j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			return "Point [i=" + i + ", j=" + j + "]";
		}
	}
}