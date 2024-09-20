import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] input = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		int lIdx = 0;
		int rIdx = 0;
		int[] numCnt = new int[100001];
		int maxLen = 0;
		while (rIdx < N) {
			numCnt[input[rIdx]]++;
			if (numCnt[input[rIdx]] > K) {
				while (lIdx < rIdx) {
					numCnt[input[lIdx]]--;
					lIdx++;

					if (numCnt[input[rIdx]] <= K) {
						break;
					}
				}
			}

			maxLen = Math.max(maxLen, rIdx - lIdx + 1);
			rIdx++;
		}

		System.out.println(maxLen);
	}
}