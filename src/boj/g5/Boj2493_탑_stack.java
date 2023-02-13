package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj2493_탑_stack {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Tower> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			Tower t = new Tower(i, Integer.parseInt(st.nextToken()));
			if (!stack.isEmpty()) {
				while (stack.peek().height < t.height) {
					stack.pop();
					if (stack.isEmpty())
						break;
				}
			}

			if (!stack.isEmpty()) {
				sb.append(stack.peek().idx).append(" ");
			} else {
				sb.append(0).append(" ");
			}
			stack.add(t);
		}
		System.out.println(sb.toString());
	}

	static class Tower {
		int idx;
		int height;

		public Tower(int idx, int height) {
			super();
			this.idx = idx;
			this.height = height;
		}
	}
}
