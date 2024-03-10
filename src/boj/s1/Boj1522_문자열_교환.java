package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1522_문자열_교환 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		str = str + str;

		int answer = len;
		for (int s = 0; s < len; s++) {
			int left = s;
			int right = s + len - 1;

			int count = 0;
			while (left < right) {
				while (left < right && str.charAt(left) == 'a') {
					left++;
				}
				while (left < right && str.charAt(right) == 'b') {
					right--;
				}

				if (str.charAt(left) == 'b' && str.charAt(right) == 'a' && left < right) {
					count++;
				}
				left++;
				right--;
			}

			answer = Math.min(answer, count);
		}

		System.out.println(answer);
	}
}
