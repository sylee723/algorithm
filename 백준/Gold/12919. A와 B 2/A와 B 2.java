import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean available;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S = br.readLine();
		String T = br.readLine();

		available = false;
		isAvailable(T, S);

		if (available) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
	}

	private static void isAvailable(String now, String start) {
		if (now.equals(start)) {
			available = true;
			return;
		}
		if (available || now.length() <= start.length()) {
			return;
		}

		int len = now.length();
		String reverseStr = "";
		for (int i = len - 1; i >= 0; i--) {
			reverseStr += now.charAt(i);
		}

		if (now.charAt(len - 1) == 'A'
				&& (now.substring(0, len - 1).contains(start) || reverseStr.substring(1).contains(start))) {
			isAvailable(now.substring(0, len - 1), start);
		}

		if (reverseStr.charAt(len - 1) == 'B'
				&& (reverseStr.substring(0, len - 1).contains(start) || now.substring(1).contains(start))) {
			isAvailable(reverseStr.substring(0, len - 1), start);
		}
	}
}