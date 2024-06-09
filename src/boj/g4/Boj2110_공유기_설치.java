package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2110_공유기_설치 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[] point = new int[N];
		for (int n = 0; n < N; n++) {
			point[n] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(point);
		int answer = binarySearch(point, C);

		System.out.println(answer);
	}

	private static int binarySearch(int[] point, int c) {
		int start = 1;
		int end = point[point.length - 1] - point[0];

		int answer = 0;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (isAvailable(point, c, mid)) {
				answer = Math.max(answer, mid);
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return answer;
	}

	private static boolean isAvailable(int[] point, int C, int minD) {
		int count = 1;
		int prev = point[0];

		for (int i = 1; i < point.length; i++) {
			if (point[i] - prev >= minD) {
				count++;
				prev = point[i];
			}
		}

		if (count >= C) {
			return true;
		}

		return false;
	}
}
