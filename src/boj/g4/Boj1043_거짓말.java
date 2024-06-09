package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj1043_거짓말 {
	static int TRUTH = 0;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		makeSet(parent);

		for (int t = 0; t < T; t++) {
			int num = Integer.parseInt(st.nextToken());
			parent[num] = TRUTH;
		}

		ArrayList<Integer>[] party = new ArrayList[M];
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			party[m] = new ArrayList<>();

			for (int p = 0; p < P; p++) {
				int participant = Integer.parseInt(st.nextToken());
				party[m].add(participant);

				union(party[m].get(0), participant);
			}
		}

		int count = 0;
		for (int m = 0; m < M; m++) {
			boolean lie = true;
			for (int participant : party[m]) {
				if (findSet(participant) == TRUTH) {
					lie = false;
					break;
				}
			}

			if (lie) {
				count++;
			}
		}

		System.out.println(count);
	}

	private static void makeSet(int[] parent) {
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
	}

	private static int findSet(int x) {
		if (x == parent[x]) {
			return x;
		}

		return parent[x] = findSet(parent[x]);
	}

	private static void union(int A, int B) {
		int parentA = findSet(A);
		int parentB = findSet(B);

		if (parentA == parentB) {
			return;
		}

		if (parentA > parentB) {
			parent[parentA] = parentB;
		} else {
			parent[parentB] = parentA;
		}
	}

}
