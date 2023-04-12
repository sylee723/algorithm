package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// fail
public class Swea2383_점심_식사시간 {
	static int N, stair1, stair2, answer;
	static int[][] map, pMap;
	static Map<Integer, Person> people;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static boolean[] selected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			pMap = new int[N][N];
			people = new HashMap<>();
			stair1 = 0;
			stair2 = 0;
			int i1 = -1, j1 = -1, i2 = -1, j2 = -1;
			int num = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > 1 && stair1 == 0) {
						stair1 = map[i][j];
						i1 = i;
						j1 = j;
					} else if (map[i][j] > 1) {
						stair2 = map[i][j];
						i2 = i;
						j2 = j;
					} else if (map[i][j] == 1) {
						pMap[i][j] = num;
						people.put(num, new Person(num, i, j, 0, 0));
						num++;
					}
				}
			}

			for (int i = 0; i < people.size(); i++) { // 계단 입구까지 이동 시간 계산
				Person p = people.get(i);
				int t1 = Math.abs(p.i - i1) + Math.abs(p.j - j1);
				int t2 = Math.abs(p.i - i2) + Math.abs(p.j - j2);
				p.time1 = t1;
				p.time2 = t2;
				people.put(i, p);
			}

			selected = new boolean[people.size()];
			answer = Integer.MAX_VALUE;
			subset(0, 0);

			System.out.println("#" + tc + " " + answer);
		}
	}

	private static void subset(int idx, int cnt) {
		if (idx == people.size()) {
			int[] s1People = new int[cnt];
			int[] s2People = new int[people.size() - cnt];

			int i1 = 0;
			int i2 = 0;
			for (int i = 0; i < selected.length; i++) {
				Person person = people.get(i);
				if (selected[i]) { // 계단 1로 내려감
					s1People[i1] = person.time1 + 1 + stair1; // 이동 시간 + 계단 입구 대기 시간 + 계단 내려가는 시간
					i1++;
				} else { // 계단 2로 내려감
					s2People[i2] = person.time2 + 1 + stair2;
					i2++;
				}
			}
			int t1 = calcTotalTime(s1People, 1);
			int t2 = calcTotalTime(s2People, 2);

			int result = Math.max(t1, t2);
			answer = Math.min(answer, result);
			return;
		}
		selected[idx] = true;
		subset(idx + 1, cnt + 1);
		selected[idx] = false;
		subset(idx + 1, cnt);
	}

	private static int calcTotalTime(int[] sPeople, int sNum) {
		Arrays.sort(sPeople);
		if (sPeople.length == 0) {
			return 0;
		} else if (sPeople.length <= 3) {
			return sPeople[sPeople.length - 1];
		}

		int time = 0;
		int stair = sNum == 1 ? stair1 : stair2;

		while (true) {
			if (sPeople[sPeople.length - 1] == 0) // 마지막 사람까지 이동완료
				return time;
			int onStair = 0;
			for (int i = 0; i < sPeople.length; i++) {

				if (sPeople[i] == 0) { // 이동 완료
					continue;
				}
				sPeople[i]--;
				if (sPeople[i] > 0 && sPeople[i] <= stair) { // 계단 내려가기 시작
					onStair++;
				}
				if (onStair >= 4) {
					sPeople[i]++;
				}

			}

			time++;
		}
	}

	static class Person {

		int pnum, i, j, time1, time2;

		public Person(int pnum, int i, int j, int time1, int time2) {
			this.pnum = pnum;
			this.i = i;
			this.j = j;
			this.time1 = time1;
			this.time2 = time2;
		}

		@Override
		public String toString() {
			return "Person [pnum=" + pnum + ", i=" + i + ", j=" + j + ", time1=" + time1 + ", time2=" + time2 + "]";
		}
	}
}
