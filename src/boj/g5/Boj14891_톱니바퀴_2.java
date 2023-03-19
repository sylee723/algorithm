package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj14891_톱니바퀴_2 {
	static Wheel[] wheels;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		wheels = new Wheel[T];
		for (int i = 0; i < T; i++) {
			String line = br.readLine();
			int[] arr = new int[8];
			for (int j = 0; j < 8; j++) {
				arr[j] = line.charAt(j) - '0';
			}
			wheels[i] = new Wheel(arr, 0);
		}

		int K = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int w_num, dir;
		int[] before = new int[T]; // 회전하기 전 열두시 방향 인덱스
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			w_num = Integer.parseInt(st.nextToken()) - 1;
			dir = Integer.parseInt(st.nextToken());

			for (int i = 0; i < T; i++) {
				before[i] = wheels[i].si;
			}

			spin(wheels[w_num], dir);

			boolean spinLeft = true;
			boolean spinRight = true;
			for (int d = 1; d < T; d++) {
				dir = -dir;
				if (spinLeft && w_num - d >= 0 && wheels[w_num - d].arr[(before[w_num - d] + 2)
						% 8] != wheels[w_num - d + 1].arr[(before[w_num - d + 1] + 6) % 8]) { // 왼쪽 바퀴 회전
					spin(wheels[w_num - d], dir);
				} else {
					spinLeft = false;
				}
				if (spinRight && w_num + d < T && wheels[w_num + d - 1].arr[(before[w_num + d - 1] + 2)
						% 8] != wheels[w_num + d].arr[(before[w_num + d] + 6) % 8]) {
					spin(wheels[w_num + d], dir);
				} else {
					spinRight = false;
				}
			}
		}

		int answer = 0;
		for (int i = 0; i < T; i++) {
			answer += wheels[i].arr[wheels[i].si];
		}

		System.out.println(answer);
	}

	static void spin(Wheel w, int d) { // 바퀴, 회전 방향
		int idx = w.si;
		if (d == 1) { // 시계 방향
			idx = idx == 0 ? 7 : idx - 1;
		} else { // 반시계 방향
			idx = idx == 7 ? 0 : idx + 1;
		}
		w.si = idx;
	}

	static class Wheel {
		int[] arr;
		int si; // 열두시 방향 인덱스

		@Override
		public String toString() {
			return "Wheel [arr=" + Arrays.toString(arr) + ", si=" + si + "]\n";
		}

		public Wheel(int[] arr, int si) {
			super();
			this.arr = arr;
			this.si = si;
		}
	}
}
