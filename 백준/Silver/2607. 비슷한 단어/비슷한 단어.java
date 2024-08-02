import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] count = new int[N]['Z' - 'A' + 1];
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			for (int j = 0; j < word.length(); j++) {
				char ch = word.charAt(j);
				count[i][ch - 'A']++;
			}
		}

		int answer = 0;
		for (int i = 1; i < N; i++) {
			int cnt1 = 0;
			int cnt2 = 0;
			for (int j = 0; j < count[0].length; j++) {
				if (count[0][j] > count[i][j]) {
					cnt1 += (count[0][j] - count[i][j]);
				} else if (count[0][j] < count[i][j]) {
					cnt2 += (count[i][j] - count[0][j]);
				}
			}

			if (cnt1 <= 1 && cnt2 <= 1) {
				answer++;
			}
		}

		System.out.println(answer);
	}
}