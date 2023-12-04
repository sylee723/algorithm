package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj18870_좌표_압축 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[N];
		int[] sortedArr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sortedArr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(sortedArr);
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		int num = sortedArr[0];
		map.put(num, count);
		for (int i = 1; i < N; i++) {
			if (sortedArr[i] != num) {
				count++;
				map.put(sortedArr[i], count);
			}
			num = sortedArr[i];
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(map.get(arr[i])).append(" ");
		}
		System.out.println(sb.toString());
	}
}
