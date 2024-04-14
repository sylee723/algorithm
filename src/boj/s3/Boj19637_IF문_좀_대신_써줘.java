package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj19637_IF문_좀_대신_써줘 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[] name = new String[N];
		int[] power = new int[N];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			name[n] = st.nextToken();
			power[n] = Integer.parseInt(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		for (int m = 0; m < M; m++) {
			int p = Integer.parseInt(br.readLine());
			int idx = getPower(p, power);
			sb.append(name[idx]).append("\n");
		}

		System.out.println(sb.toString());
	}

	private static int getPower(int p, int[] power) {
		int start = 0;
		int end = power.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (p <= power[mid]) {
				end = mid - 1;
			} else if (p > power[mid]) {
				start = mid + 1;
			}

		}

		return start;
	}
}
