package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea6808_규영이와_인영이의_카드게임 {
	static int[] kyuyoungCards;
	static int[] inyoungCards;
	static boolean[] used;
	static int[] result;
	static int k_win;
	static int k_lose;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			kyuyoungCards = new int[9];
			boolean[] selectedCards = new boolean[19];
			for (int i = 0; i < 9; i++) {
				kyuyoungCards[i] = Integer.parseInt(st.nextToken());
				selectedCards[kyuyoungCards[i]] = true;
			}
			inyoungCards = new int[9];
			int i = 0;
			for (int n = 1; n <= 18; n++) {
				if (!selectedCards[n]) {
					inyoungCards[i] = n;
					i++;
				}
			} // 인영이가 받은 카드 구함

			used = new boolean[9];
			result = new int[9];
			k_win = 0;
			k_lose = 0;
			perm(0);

			System.out.println("#" + t + " " + k_win + " " + k_lose);
		}
	}

	static void perm(int idx) {
		if (idx == 9) {
			int k_score = 0;
			int i_score = 0;
			for (int i = 0; i < 9; i++) {
				if (kyuyoungCards[i] > result[i])
					k_score += kyuyoungCards[i] + result[i];
				else
					i_score += kyuyoungCards[i] + result[i];
			}
			if (k_score > i_score)
				k_win++;
			else if (i_score > k_score)
				k_lose++;
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (used[i])
				continue;
			result[idx] = inyoungCards[i];
			used[i] = true;
			perm(idx + 1);
			used[i] = false;
		}
	}
}
