import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] len = new int[N - 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			len[i] = Integer.parseInt(st.nextToken());
		}

		int[] price = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < N; i++) {
			price[i] = Math.min(price[i], price[i - 1]);
		}

		long answer = 0;
		for (int i = 0; i < N - 1; i++) {
			answer += (long) len[i] * price[i];
		}

		System.out.println(answer);
	}
}