package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj6987_월드컵 {
	static int[][] input, result;
	static int[] teamA, teamB;
	static int answer;

	public static void main(String[] args) throws IOException {
		int t = 0;
		teamA = new int[15];
		teamB = new int[15];
		for (int i = 0; i < 6; i++) {
			for (int j = i + 1; j < 6; j++) {
				teamA[t] = i;
				teamB[t] = j;
				t++;
			}
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		input = new int[6][3];
		for (int tc = 0; tc < 4; tc++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			answer = 0;
			result = new int[6][3];
			perm(0);
			System.out.print(answer + " ");
		}
	}

	static void perm(int idx) {
		if (idx == 15) {
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					if (input[i][j] != result[i][j]) {
						return;
					}
				}
			}
			answer = 1;
			return;
		}

		int A = teamA[idx];
		int B = teamB[idx];

		// teamA 이기는 경우
		result[A][0]++;
		result[B][2]++;
		perm(idx + 1);
		result[A][0]--;
		result[B][2]--;

		// teamB 이기는 경우
		result[A][2]++;
		result[B][0]++;
		perm(idx + 1);
		result[A][2]--;
		result[B][0]--;

		// 비기는 경우
		result[A][1]++;
		result[B][1]++;
		perm(idx + 1);
		result[A][1]--;
		result[B][1]--;
	}
}
