import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] price = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;
		for (int i = 0; i < N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, price[i]);
		}

		int M = Integer.parseInt(br.readLine());

		int answer = binarySearch(price, 1, max, M);
		System.out.println(answer);
	}

	private static int binarySearch(int[] arr, int start, int end, int M) {
		int mid;
		int result = 0;
		while (start <= end) {
			mid = (start + end) / 2;
			int sum = 0;
			for (int num : arr) {
				sum += Math.min(num, mid);
			}

			if (sum == M) {
				result = mid;
				break;
			} else if (sum < M) {
				result = Math.max(result, mid);
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return result;
	}
}