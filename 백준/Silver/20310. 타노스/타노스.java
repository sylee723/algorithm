import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] S = br.readLine().toCharArray();
		int[] count = new int[2];

		for (int i = 0; i < S.length; i++) {
			count[S[i] - '0']++;
		}

		boolean[] remove = new boolean[S.length];
		for (int i = S.length - 1; i >= 0; i--) {
			if (S[i] == '0' && count[0] > 0) {
				remove[i] = true;
				count[0] -= 2;
			}
		}

		for (int i = 0; i < S.length; i++) {
			if (S[i] == '1' && count[1] > 0) {
				remove[i] = true;
				count[1] -= 2;
			}
		}

		String answer = "";
		for (int i = 0; i < S.length; i++) {
			if (!remove[i]) {
				answer += S[i];
			}
		}

		System.out.println(answer);
	}
}