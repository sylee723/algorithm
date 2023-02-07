package boj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//스위치 켜고 끄기
public class Boj1244 {
	static boolean[] switchOn;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		switchOn = new boolean[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			if (Integer.parseInt(st.nextToken()) == 1)
				switchOn[i] = true;
		}

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int student = Integer.parseInt(st.nextToken());
			if (student == 1) { // 남학생
				int num = Integer.parseInt(st.nextToken());
				boySwitch(num);
			} else if (student == 2) { // 여학생
				int num = Integer.parseInt(st.nextToken());
				girlSwitch(num);
			}
		}

		for (int i = 1; i <= n; i++) {
			System.out.print(switchOn[i] ? "1 " : "0 ");
			if (i % 20 == 0)
				System.out.println();
		}
	}

	static void boySwitch(int n) {
		for (int i = 1; i < switchOn.length; i++) {
			if (i % n == 0) {
				switchOn[i] = !switchOn[i];
			}
		}
	}

	static void girlSwitch(int n) {
		int d = 1;
		int si = n, ei = n;
		while (true) {
			if (n - d < 1 || n + d >= switchOn.length)
				break;
			if (switchOn[n - d] != switchOn[n + d])
				break;
			si = n - d;
			ei = n + d;
			d++;
		}
		for (int i = si; i <= ei; i++) {
			switchOn[i] = !switchOn[i];
		}
	}
}
