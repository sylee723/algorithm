package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1515_수_이어_쓰기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int N = 1;
		int i = 0;

		String now = Integer.toString(N);
		while (i < input.length()) {
			while (now.indexOf(input.charAt(i)) == -1) {
				N++;
				now = Integer.toString(N);
			}

			int sIdx = now.indexOf(input.charAt(i));
			now = now.substring(sIdx + 1);
			i++;
		}

		System.out.println(N);
	}
}
