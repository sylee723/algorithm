package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj14888_연산자_끼워넣기_중복제거버전 {
	static int N, maxAns, minAns;
	static int[] number, operator;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		number = new int[N];
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		operator = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		maxAns = Integer.MIN_VALUE;
		minAns = Integer.MAX_VALUE;

		calc(0, number[0]);
		System.out.println(maxAns);
		System.out.println(minAns);
	}

	static void calc(int idx, int op_result) {
		if (idx == N - 1) {
			maxAns = Math.max(maxAns, op_result);
			minAns = Math.min(minAns, op_result);
			return;
		}

		// operator +, -, *, /
		if (operator[0] > 0) {
			operator[0]--;
			calc(idx + 1, op_result + number[idx + 1]);
			operator[0]++;
		}
		if (operator[1] > 0) {
			operator[1]--;
			calc(idx + 1, op_result - number[idx + 1]);
			operator[1]++;
		}
		if (operator[2] > 0) {
			operator[2]--;
			calc(idx + 1, op_result * number[idx + 1]);
			operator[2]++;
		}
		if (operator[3] > 0) {
			operator[3]--;
			calc(idx + 1, op_result / number[idx + 1]);
			operator[3]++;
		}

	}
}
