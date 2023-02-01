package boj.s2;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// 연결 요소의 개수
public class Boj11724 {
	public static int findParent(int[] parent, int x) {
		if (parent[x] != x) {
			parent[x] = findParent(parent, parent[x]);
		}
		return parent[x];
	}

	public static void unionParent(int[] parent, int a, int b) {
		a = findParent(parent, a);
		b = findParent(parent, b);
		if (a < b) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
//		System.out.println(Arrays.toString(parent));
		for (int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			unionParent(parent, u, v);
		}
//		System.out.println(Arrays.toString(parent));

		Set<Integer> connected = new HashSet<>();
		for (int i = 1; i <= n; i++) {
			int temp = findParent(parent, i);
			if (!(connected.contains(temp)))
				connected.add(temp);
		}
		System.out.println(connected.size());
	}
}
