import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Character> beforeC = new Stack<>();
		Stack<Character> afterC = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			beforeC.add(str.charAt(i));
		}

		int M = Integer.parseInt(br.readLine());
		for (int m = 0; m < M; m++) {
			String cmd = br.readLine();
			char ch = cmd.charAt(0);
			switch (ch) {
			case 'L':
				if (!beforeC.isEmpty()) {
					char top = beforeC.pop();
					afterC.add(top);
				}
				break;
			case 'D':
				if (!afterC.isEmpty()) {
					char top = afterC.pop();
					beforeC.add(top);
				}
				break;
			case 'B':
				if (!beforeC.isEmpty()) {
					beforeC.pop();
				}
				break;
			case 'P':
				beforeC.add(cmd.charAt(2));
				break;
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!beforeC.isEmpty()) {
			sb.append(beforeC.pop());
		}
		String answer = sb.reverse().toString();

		sb.setLength(0);
		while (!afterC.isEmpty()) {
			sb.append(afterC.pop());
		}
		answer += sb.toString();

		System.out.println(answer);
	}
}