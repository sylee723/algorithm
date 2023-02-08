package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//로또
public class Boj6603_조합_부분집합버전 {
	static int k;
	static int[] S;
	static boolean[] selected;
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
			selected = new boolean[k];

			comb(0, 0);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static void comb(int idx, int cnt) {
		if (cnt == 6) {
			for (int i = 0; i < k; i++) {
				if (selected[i])
					sb.append(S[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		if (idx == k)
			return;

		selected[idx] = true;
		comb(idx + 1, cnt + 1);
		selected[idx] = false;
		comb(idx + 1, cnt);
	}
}
