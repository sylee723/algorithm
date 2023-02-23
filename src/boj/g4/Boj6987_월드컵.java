package boj.g4;

import java.util.Arrays;
import java.util.Scanner;

//해결 못함
public class Boj6987_월드컵 {
	static int[][] input, result;
	static int[] teamA, teamB, winlose;
	static int answer;

	public static void main(String[] args) {
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

		Scanner sc = new Scanner(System.in);
		int[][] input = new int[6][3];
		for (int tc = 0; tc < 4; tc++) {
			
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					input[i][j] = sc.nextInt();
				}
			}
			answer = 0;
			winlose = new int[15];
			
			perm(0);
			System.out.println(answer);

		}
	}

	static void perm(int idx) {
		if (idx == 15) {
			result = new int[6][3];
			for (int i = 0; i < 15; i++) {
				if (winlose[i] == 1) {
					result[teamA[i]][0]++;
					result[teamB[i]][2]++;
				} else if (winlose[i] == -1) {
					result[teamA[i]][2]++;
					result[teamB[i]][0]++;
				} else if (winlose[i] == 0) {
					result[teamA[i]][2]++;
					result[teamB[i]][2]++;
				}
			}

			boolean check = true;
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					if (input[i][j] != result[i][j]) {
						check = false;
					}
				}
			}
			if (check)
				answer = 1;
			return;
		}
		
		// 이기는 경우 지는 경우 그때그때 대입
		winlose[idx] = -1;
		perm(idx + 1);
		winlose[idx] = 0;
		perm(idx + 1);
		winlose[idx] = 1;
		perm(idx + 1);
	}
}
