package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj5639_이진_검색_트리 {
	static ArrayList<Integer> input = new ArrayList<>();
	static Node[] tree;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";

		while ((line = br.readLine()) != null && !line.isEmpty()) {
			int num = Integer.parseInt(line);
			input.add(num);
		}

		tree = new Node[input.size()];
		makeTree(0, tree.length - 1);

		postorder(0);
		System.out.println(sb.toString());
	}

	private static void postorder(int now) {
		if (tree[now].left != -1) {
			postorder(tree[now].left);
		}
		if (tree[now].right != -1) {
			postorder(tree[now].right);
		}
		sb.append(tree[now].value).append("\n");
	}

	private static void makeTree(int idx, int end) {
		int now = input.get(idx);
		tree[idx] = new Node(now);

		if (idx == end) {
			return;
		}

		int right = end + 1;
		for (int i = idx + 1; i <= end; i++) {
			if (now < input.get(i)) {
				right = i;
				break;
			}
		}

		if (idx + 1 < right) {
			tree[idx].left = idx + 1;
			makeTree(idx + 1, right - 1);
		}

		if (right <= end) {
			tree[idx].right = right;
			makeTree(right, end);
		}
	}

	static class Node {
		int value;
		int left, right;

		public Node(int value) {
			this.value = value;
			this.left = -1;
			this.right = -1;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + ", left=" + left + ", right=" + right + "]";
		}
	}
}
