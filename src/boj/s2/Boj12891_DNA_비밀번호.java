package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj12891_DNA_비밀번호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int lenS = Integer.parseInt(st.nextToken());
		int lenP = Integer.parseInt(st.nextToken());

		String DNA_str = br.readLine();
		int[][] count_ACGT = new int[lenS + 1][4];

		for (int i = 0; i < lenS; i++) {
			count_ACGT[i + 1] = Arrays.copyOf(count_ACGT[i], 4);
			switch (DNA_str.charAt(i)) {
			case 'A':
				count_ACGT[i + 1][0]++;
				break;
			case 'C':
				count_ACGT[i + 1][1]++;
				break;
			case 'G':
				count_ACGT[i + 1][2]++;
				break;
			case 'T':
				count_ACGT[i + 1][3]++;
				break;
			}
		}

		st = new StringTokenizer(br.readLine());
		int[] min_num = new int[4];
		for (int i = 0; i < 4; i++) {
			min_num[i] = Integer.parseInt(st.nextToken());
		}

		int answer = 0;
		for (int i = 0; i <= lenS - lenP; i++) { // 부분문자열에 대해
			boolean password = true;
			for (int j = 0; j < 4; j++) { // ACGT 각각에 대해
				int count = count_ACGT[i + lenP][j] - count_ACGT[i][j];
				if (count < min_num[j]) {
					password = false;
					break;
				}
			}
			if (password)
				answer++;
		}

		System.out.println(answer);
	}
}
