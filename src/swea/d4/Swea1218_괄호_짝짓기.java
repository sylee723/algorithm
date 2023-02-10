package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Swea1218_괄호_짝짓기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			Stack<Character> stack = new Stack<>();
			int result = 1; // 유효성 여부
			for (int i = 0; i < N; i++) {
				char c = input.charAt(i);
				switch (c) {
				case '(':
					stack.add(')');
					break;
				case '[':
					stack.add(']');
					break;
				case '{':
					stack.add('}');
					break;
				case '<':
					stack.add('>');
					break;
				case ')':
				case ']':
				case '}':
				case '>':
					if (stack.isEmpty() || c != stack.pop()) {
						result = 0;
					}
					break;
				}
				if (result == 0)
					break;
			}
			if (!stack.isEmpty())
				result = 0;

			System.out.println("#" + tc + " " + result);
		}
	}
}
