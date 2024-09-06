import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String bomb = br.readLine();
		ArrayDeque<Character> stack = new ArrayDeque<>();

		int idx = 0;
		int len = str.length();
		int bombLen = bomb.length();
		ArrayDeque<Character> word = new ArrayDeque<>();

		while (idx < len) {
			stack.add(str.charAt(idx));
			idx++;

			if (stack.size() >= bombLen) { // 문자열 비교
				boolean check = true;
				for (int i = 0; i < bombLen; i++) {
					char ch = stack.pollLast();
					word.addFirst(ch);

					if (ch != bomb.charAt(bombLen - i - 1)) {
						check = false;
						break;
					}
				}

				if (!check) {
					stack.addAll(word);
				}
				word.clear();
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pollFirst());
		}
		if (sb.length() == 0) {
			sb.append("FRULA");
		}

		System.out.println(sb.toString());
	}
}