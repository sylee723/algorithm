import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int minValue;
	static int[] value, answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		value = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			value[i] = Integer.parseInt(st.nextToken());
		}

		minValue = Integer.MAX_VALUE;
		answer = new int[2];

		for (int i = 0; i < N - 1; i++) {
			binarySearch(value[i], i + 1, N - 1);
		}

		System.out.println(answer[0] + " " + answer[1]);
	}

	private static void binarySearch(int v1, int start, int end) {
		int mid, v2;
		while (start <= end) {
			mid = (start + end) / 2;
			v2 = value[mid];

			if (Math.abs(v1 + v2) < minValue) {
				minValue = Math.abs(v1 + v2);
				answer[0] = v1;
				answer[1] = v2;
			}

			if (v1 + v2 == 0) {
				return;
			} else if (v1 + v2 > 0) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
	}
}