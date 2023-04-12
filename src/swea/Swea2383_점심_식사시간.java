package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

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
			bfs(i1, j1, 1);
			bfs(i2, j2, 2);

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

	private static void bfs(int i, int j, int stair) {
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];
		visited[i][j] = true;
		queue.add(new int[] { i, j });

		int time = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				int[] now = queue.poll();
				if (map[now[0]][now[1]] == 1) {
					int pNum = pMap[now[0]][now[1]];
					Person p = people.get(pNum);
					if (stair == 1) {
						p.time1 = time;
					} else if (stair == 2) {
						p.time2 = time;
					}
					people.put(pNum, p);
				}

				for (int d = 0; d < 4; d++) {
					int nexti = now[0] + di[d];
					int nextj = now[1] + dj[d];

					if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < N && !visited[nexti][nextj]
							&& map[nexti][nextj] < 2) {
						queue.add(new int[] { nexti, nextj });
						visited[nexti][nextj] = true;
					}
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
