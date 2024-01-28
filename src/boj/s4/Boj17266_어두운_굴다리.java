package boj.s4;

import java.util.Scanner;

public class Boj17266_어두운_굴다리 {
	static int N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		int[] lamp = new int[M];
		for (int i = 0; i < M; i++) {
			lamp[i] = sc.nextInt();
		}

		System.out.println(binarySearch(1, N, lamp));
//		int distance = 0;
//		for (int i = 1; i < M; i++) {
//			distance = Math.max(distance, lamp[i] - lamp[i - 1]);
//		}
//
//		int h = distance / 2;
//		if (distance % 2 != 0)
//			h++;
//
//		h = Math.max(h, lamp[0]);
//		h = Math.max(h, N - lamp[M - 1]);
//
//		System.out.println(h);
	}

	private static int binarySearch(int start, int end, int[] lamp) {
		int answer = -1;

		while (start <= end) {
			int mid = (start + end) / 2;
			boolean bright = true;
			for (int i = 1; i < M; i++) {
				int distance = lamp[i] - lamp[i - 1];
				if (distance > mid * 2) {
					bright = false;
					break;
				}
			}

			if (lamp[0] > mid || N - lamp[M - 1] > mid) {
				bright = false;
			}

			if (bright) {
				answer = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return answer;
	}
}
