package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1991_트리_순회 {
	static int[][] tree;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		tree = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char parent = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);

			tree[parent - 'A'][0] = left - 'A';
			tree[parent - 'A'][1] = right - 'A';
		}

		preorder(0);
		sb.append("\n");
		inorder(0);
		sb.append("\n");
		postorder(0);

		System.out.println(sb.toString());
	}

	private static void preorder(int idx) {
		if (idx < 0)
			return;

		sb.append((char) ('A' + idx));
		preorder(tree[idx][0]);
		preorder(tree[idx][1]);
	}

	private static void inorder(int idx) {
		if (idx < 0)
			return;

		inorder(tree[idx][0]);
		sb.append((char) ('A' + idx));
		inorder(tree[idx][1]);
	}

	private static void postorder(int idx) {
		if (idx < 0)
			return;

		postorder(tree[idx][0]);
		postorder(tree[idx][1]);
		sb.append((char) ('A' + idx));
	}
}
