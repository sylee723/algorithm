package boj.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj12015_가장_긴_증가하는_부분_수열_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] C = new int[N];
		int size = 0;

		for (int i = 0; i < N; i++) {
			int idx = binarySearch(C, size, arr[i]);
			C[idx] = arr[i];

			if (idx == size)
				size++;
		}

		System.out.println(size);
	}

	private static int binarySearch(int[] C, int size, int key) {
		int start = 0;
		int end = size - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (C[mid] == key) {
				return mid;
			} else if (C[mid] > key) {

				end = mid - 1;
			} else if (C[mid] < key) {
				start = mid + 1;
			}
		}

		return start;
	}
}
