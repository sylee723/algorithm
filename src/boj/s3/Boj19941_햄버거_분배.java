package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj19941_햄버거_분배 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		ArrayList<Integer> personIdx = new ArrayList<>();
		boolean[] hamburger = new boolean[N];

		String table = br.readLine();
		for (int i = 0; i < N; i++) {
			if (table.charAt(i) == 'P') {
				personIdx.add(i);
			} else {
				hamburger[i] = true;
			}
		}

		int count = 0;
		for (int idx : personIdx) {
			for (int i = Math.max(0, idx - K); i <= Math.min(N - 1, idx + K); i++) {
				if (hamburger[i]) {
					hamburger[i] = false;
					count++;
					break;
				}
			}
		}

		System.out.println(count);
	}
}
