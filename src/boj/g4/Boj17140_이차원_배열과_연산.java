package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj17140_이차원_배열과_연산 {
	static int[][] arr;
	static int nowR, nowC;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		arr = new int[101][101];

		for (int i = 1; i <= 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		nowR = 3;
		nowC = 3;
		int time = 0;

		while (true) {
			if (arr[r][c] == k)
				break;

			if (time >= 100) {
				time = -1;
				break;
			}

			// R연산 또는 C연산
			if (nowR >= nowC) {
				calcR();
			} else {
				calcC();
			}

			time++;
		}

		System.out.println(time);
	}

	private static void calcR() {
		PriorityQueue<Num> pq = new PriorityQueue<>();
		int[] count = new int[101];
		int maxC = 0;
		for (int i = 1; i <= nowR; i++) {
			for (int j = 1; j <= 100; j++) {
				if (arr[i][j] != 0) {
					count[arr[i][j]]++;
					arr[i][j] = 0;
				}
			}

			for (int x = 1; x <= 100; x++) {
				if (count[x] != 0) {
					pq.add(new Num(x, count[x]));
					count[x] = 0;
				}
			}

			int j = 1;
			while (!pq.isEmpty()) {
				Num num = pq.poll();
				arr[i][j] = num.value;
				arr[i][j + 1] = num.count;

				j += 2;
			}

			maxC = Math.max(maxC, j - 1);
		}

		nowC = maxC;
	}

	private static void calcC() {
		PriorityQueue<Num> pq = new PriorityQueue<>();
		int[] count = new int[101];
		int maxR = 0;
		for (int j = 1; j <= nowC; j++) {
			for (int i = 1; i <= 100; i++) {
				if (arr[i][j] != 0) {
					count[arr[i][j]]++;
					arr[i][j] = 0;
				}
			}

			for (int x = 1; x <= 100; x++) {
				if (count[x] != 0) {
					pq.add(new Num(x, count[x]));
					count[x] = 0;
				}
			}

			int i = 1;
			while (!pq.isEmpty()) {
				Num num = pq.poll();
				arr[i][j] = num.value;
				arr[i + 1][j] = num.count;

				i += 2;
			}

			maxR = Math.max(maxR, i - 1);
		}

		nowR = maxR;
	}

	static class Num implements Comparable<Num> {
		int value;
		int count;

		public Num(int value, int count) {
			super();
			this.value = value;
			this.count = count;
		}

		@Override
		public int compareTo(Num o) {
			if (this.count < o.count) {
				return -1;
			} else if (this.count > o.count) {
				return 1;
			} else {
				if (this.value < o.value)
					return -1;
				else
					return 1;
			}
		}
	}
}
