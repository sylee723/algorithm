package boj.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj4659_비밀번호_발음하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String pw = br.readLine();
			if (pw.equals("end")) {
				break;
			}

			boolean mo = false;

			boolean continuous3 = false;
			int continuousJa = 0;
			int continuousMo = 0;

			boolean sameChar = false;
			char before = ' ';

			for (int i = 0; i < pw.length(); i++) {
				if (pw.charAt(i) == 'a' || pw.charAt(i) == 'e' || pw.charAt(i) == 'i' || pw.charAt(i) == 'o'
						|| pw.charAt(i) == 'u') {
					mo = true;

					continuousJa = 0;
					continuousMo++;

				} else {
					continuousMo = 0;
					continuousJa++;
				}

				if (continuousJa >= 3 || continuousMo >= 3) {
					continuous3 = true;
					break;
				}

				if (before == pw.charAt(i) && pw.charAt(i) != 'e' && pw.charAt(i) != 'o') {
					sameChar = true;
					break;
				}
				before = pw.charAt(i);
			}

			sb.append("<").append(pw).append("> ");

			if (mo && !continuous3 && !sameChar) {
				sb.append("is acceptable.\n");
			} else {
				sb.append("is not acceptable.\n");
			}
		}

		System.out.println(sb.toString());
	}
}
