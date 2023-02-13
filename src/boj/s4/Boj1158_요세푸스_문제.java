package boj.s4;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj1158_요세푸스_문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(i + 1);
		}

		int[] result = new int[N];
		int remove_idx = 0;
		for (int i = 0; i < N; i++) {
			remove_idx = (remove_idx + K - 1) % list.size();
			result[i] = list.remove(remove_idx);
		}

		System.out.print("<");
		for (int i = 0; i < N - 1; i++) {

			System.out.print(result[i] + ", ");
		}
		System.out.print(result[N - 1] + ">");
		
		sc.close();
	}
}
