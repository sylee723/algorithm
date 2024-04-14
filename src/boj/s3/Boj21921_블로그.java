package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj21921_블로그 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		int[] count = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			count[i] = Integer.parseInt(st.nextToken());
		}

		int maxSum = 0;
		int maxCnt = 0;

		int sum = 0;
		for (int i = 0; i < X; i++) {
			sum += count[i];
		}

		maxSum = sum;
		maxCnt = 1;

		for (int i = X; i < N; i++) {
			sum -= count[i - X];
			sum += count[i];

			if (sum > maxSum) {
				maxSum = sum;
				maxCnt = 1;
			} else if (sum == maxSum) {
				maxCnt++;
			}
		}

		if (maxSum == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(maxSum + "\n" + maxCnt);
		}
	}
}
