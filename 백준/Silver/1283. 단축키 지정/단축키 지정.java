import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		boolean[] used = new boolean['z' - 'a' + 1];
		for (int i = 0; i < N; i++) {
			String option = br.readLine();
			int keyIdx = checkFirst(option.toLowerCase(), used);
			if (keyIdx == -1) {
				keyIdx = checkAll(option.toLowerCase(), used);
			}

			if (keyIdx != -1) {
				sb.append(option.substring(0, keyIdx));
				sb.append("[" + option.charAt(keyIdx) + "]");
				sb.append(option.substring(keyIdx + 1));
			} else {
				sb.append(option);
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	private static int checkFirst(String str, boolean[] used) { // 단어 첫 글자
		int idx = 0;
		while (idx < str.length()) {
			char ch = str.charAt(idx);

			if (ch >= 'a' && ch <= 'z' && !used[ch - 'a']) {
				used[ch - 'a'] = true;
				return idx;
			}

			int nextIdx = str.indexOf(' ', idx);
			if (nextIdx != -1) {
				idx = nextIdx + 1;
			} else {
				break;
			}
		}

		return -1;
	}

	private static int checkAll(String str, boolean[] used) {
		int idx = 0;
		while (idx < str.length()) {
			char ch = str.charAt(idx);

			if (ch >= 'a' && ch <= 'z' && !used[ch - 'a']) {
				used[ch - 'a'] = true;
				return idx;
			}

			idx++;
		}

		return -1;
	}
}