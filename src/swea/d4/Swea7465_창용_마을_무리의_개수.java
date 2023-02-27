package swea.d4;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Swea7465_창용_마을_무리의_개수 {
	static int N;
	static int[] disjoint;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			int M = sc.nextInt();
			disjoint = new int[N + 1];
			makeSet();

			for (int m = 0; m < M; m++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				union(a, b);
			}

			Set<Integer> set = new HashSet<>();
			for (int i = 1; i <= N; i++) {
				set.add(findSet(i));
			}

			System.out.println("#" + tc + " " + set.size());
		}
	}

	private static void makeSet() {
		for (int i = 1; i <= N; i++) {
			disjoint[i] = i;
		}
	}

	private static int findSet(int i) {
		if (i == disjoint[i])
			return i;
		else
			return disjoint[i] = findSet(disjoint[i]);
	}

	private static void union(int a, int b) {
		int p1 = findSet(a);
		int p2 = findSet(b);

		if (p1 != p2)
			disjoint[p1] = p2;
	}
}
