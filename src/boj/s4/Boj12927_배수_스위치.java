package boj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj12927_배수_스위치 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		boolean[] numSwitch = new boolean[str.length() + 1];
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'Y') {
				numSwitch[i + 1] = true;
			}
		}
		int result = 0;
		for (int i = 1; i < numSwitch.length; i++) {
			if (numSwitch[i]) {
				int n = 1;
				result++;
				while (i * n < numSwitch.length) {
					numSwitch[i * n] = !numSwitch[i * n];
					n++;
				}
			}
		}

		boolean is_on = false;
		for (int j = 1; j < numSwitch.length; j++) {
			if (numSwitch[j]) {
				is_on = true;
				break;
			}
		}
		if (is_on) // 모든 전구를 끌 수 없는 경우
			result = -1;

		System.out.println(result);
	}
}
