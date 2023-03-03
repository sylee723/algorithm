package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Swea2115_벌꿀채취 {
	static int N, M, C, maxValue;
	static int[][] honey;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			honey = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					honey[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			PriorityQueue<Box> pq = new PriorityQueue<>();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j + M - 1 < N; j++) {
					maxValue = Integer.MIN_VALUE;
					getValue(0, i, j, 0, 0);
					pq.add(new Box(i, j, j + M - 1, maxValue));
				}
			}

			Box box1 = pq.poll();
			Box box2;
			while (true) {
				box2 = pq.poll();
				if (box1.i != box2.i)
					break;
				if (box1.sj > box2.ej || box1.ej < box2.sj)
					break;
			}
//			System.out.println(box1);
//			System.out.println(box2);
			System.out.println("#" + tc + " " + (box1.value + box2.value));
		}
	}

	private static void getValue(int idx, int i, int sj, int amount, int value) {

		if (idx == M) {
			maxValue = Math.max(maxValue, value);
			return;
		}

		if (amount > C)
			return;

		if (amount + honey[i][sj + idx] <= C) { // 현재 칸 선택
			getValue(idx + 1, i, sj, amount + honey[i][sj + idx], value + (int) Math.pow(honey[i][sj + idx], 2));
		}
		getValue(idx + 1, i, sj, amount, value); // 현재 칸 선택하지 않음

	}

	static class Box implements Comparable<Box> {
		int i, sj, ej, value;

		@Override
		public String toString() {
			return "Box [i=" + i + ", sj=" + sj + ", ej=" + ej + ", value=" + value + "]";
		}

		public Box(int i, int sj, int ej, int value) {
			super();
			this.i = i;
			this.sj = sj;
			this.ej = ej;
			this.value = value;
		}

		@Override
		public int compareTo(Box o) {
			return -Integer.compare(this.value, o.value);
		}
	}
}
