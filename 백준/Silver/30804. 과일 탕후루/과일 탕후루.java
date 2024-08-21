import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] fruit = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			fruit[i] = Integer.parseInt(st.nextToken());
		}

		int[] fCnt = new int[10];
		int type = 0;
		int left = 0;
		int right = 0;
		int maxCnt = 0;
		while (true) {
			while (type <= 2 && right < N) {
				if (fCnt[fruit[right]] == 0) {
					if (type == 2) {
						break;
					}
					type++;
				}

				fCnt[fruit[right]]++;
				right++;
			}

			maxCnt = Math.max(maxCnt, right - left);
			if (right == N) {
				break;
			}

			while (type == 2) {
				fCnt[fruit[left]]--;
				if (fCnt[fruit[left]] == 0) {
					type--;
				}

				left++;
			}
		}

		System.out.println(maxCnt);
	}
}