package boj.s2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// 시간 초과
public class Boj18870_좌표_압축 {
	static int[] compArr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Set<Integer> set = new HashSet<>();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			set.add(arr[i]);
		}
		compArr = new int[set.size()];
		int idx = 0;
		for (int num : set) {
			compArr[idx] = num;
			idx++;
		}

		Arrays.sort(compArr);

		for (int i = 0; i < N; i++) {
			int result = binarySearch(0, set.size() - 1, arr[i]);
			System.out.print(result + " ");
		}
	}

	private static int binarySearch(int left, int right, int target) {
		int mid = (left + right) / 2;
		if (compArr[mid] == target) {
			return mid;
		} else if (compArr[mid] < target) {
			return binarySearch(mid + 1, right, target);
		} else {
			return binarySearch(left, mid - 1, target);
		}
	}

}
