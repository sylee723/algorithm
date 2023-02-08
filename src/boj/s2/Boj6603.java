package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//로또
public class Boj6603 {
	static int k;
	static int[] S;
	static int[] result;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if (k == 0)
				break;

			S = new int[k];
			for (int i = 0; i < k; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			result = new int[6];

			comb(0, 0);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static void comb(int idx, int start) {
		if (idx == 6) {
			for (int i = 0; i < 6; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i < k; i++) {
			result[idx] = S[i];
			comb(idx + 1, i + 1);
		}
	}
}
