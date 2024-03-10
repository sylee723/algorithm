package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj20055_컨베이어_벨트_위의_로봇 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] belt = new int[2 * N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * N; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}

		boolean[] robot = new boolean[2 * N];
		int step = 1;
		int count = 0;
		int startIdx = 0;
		int endIdx;
		while (true) {
			// 벨트 회전
			if (startIdx == 0) {
				startIdx = 2 * N - 1;
			} else {
				startIdx--;
			}

			endIdx = (startIdx + N - 1) % (2 * N);
			if (robot[endIdx]) {
				robot[endIdx] = false; // 내리는 위치의 로봇 내리기
			}

			// 로봇 이동
			int prev = endIdx;
			for (int i = 1; i < N; i++) {
				int now = (endIdx - i + 2 * N) % (2 * N);
				if (robot[now] && !robot[prev] && belt[prev] > 0) {
					robot[now] = false;
					robot[prev] = true;
					belt[prev]--;
					if (belt[prev] == 0) {
						count++;
					}

					if (prev == endIdx) {
						robot[endIdx] = false;
					}
				}
				prev = now;
			}

			// 로봇 올리기
			if (belt[startIdx] > 0) {
				robot[startIdx] = true;
				belt[startIdx]--;
				if (belt[startIdx] == 0) {
					count++;
				}
			}

			if (count >= K) {
				break;
			}

			step++;
		}

		System.out.println(step);
	}
}
