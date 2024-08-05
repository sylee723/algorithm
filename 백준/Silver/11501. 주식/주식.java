import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][2];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i][0] = Integer.parseInt(st.nextToken());
			}

			arr[N - 1][1] = arr[N - 1][0];
			long answer = 0;
			for (int i = N - 2; i >= 0; i--) {
				arr[i][1] = Math.max(arr[i + 1][1], arr[i][0]);
				if (arr[i][0] < arr[i][1]) {
					answer += (arr[i][1] - arr[i][0]);
				}
			}

			System.out.println(answer);
		}
	}
}