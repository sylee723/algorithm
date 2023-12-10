package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj5525_IOIOI {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String str = br.readLine();

		int len = 2 * N + 1;
		int count = 0;

		if (str.charAt(0) == 'I')
			count++;

		int answer = 0;
		for (int i = 1; i < M; i++) {
			if (str.charAt(i - 1) != str.charAt(i) && count > 0) {
				count++;
			} else {
				if (str.charAt(i) == 'I') {
					count = 1;
				} else {
					count = 0;
				}
			}

			if (count >= len && str.charAt(i) == 'I') {
				answer++;
			}
		}

		System.out.println(answer);
	}
}
