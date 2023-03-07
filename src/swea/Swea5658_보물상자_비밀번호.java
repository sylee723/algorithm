package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Swea5658_보물상자_비밀번호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			char[] input = br.readLine().toCharArray();
			Set<Integer> numSet = new HashSet<>();

			for (int s = 0; s < N; s++) {
				int power = N / 4 - 1;
				int num = 0;
				for (int i = s; i < s + N / 4; i++) {
					num += Math.pow(16, power) * hexToDecimal(input[i % N]);
					power--;
				}
				numSet.add(num);
			}

			int[] result = new int[numSet.size()];
			int idx = 0;
			for (int n : numSet) {
				result[idx++] = n;
			}

			Arrays.sort(result);
			System.out.println("#" + tc + " " + result[numSet.size() - K]);
		}
	}

	private static int hexToDecimal(char c) {
		if (c >= '0' && c <= '9')
			return c - '0';
		else // 'A' ~ 'F'
			return c - 'A' + 10;
	}
}
