import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int mod = 1000000007;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());

		StringTokenizer st;
		int N, S, D;
		int a, b;
		long inverse;

		long expectation = 0;
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			D = gcd(N, S);

			a = S / D;
			b = N / D;

			inverse = power(b % mod, mod - 2) % mod;
			expectation += (a * inverse) % mod;
			expectation %= mod;
		}

		System.out.println(expectation);
	}

	private static long power(int num, int exp) {
		if (exp == 1) {
			return num;
		}

		long ret = power(num, exp / 2);
		ret %= mod;

		if (exp % 2 == 0) {
			return (ret * ret) % mod;
		} else {
			return (ret * ret) % mod * num;
		}
	}

	private static int gcd(int a, int b) {
		if (a < b) {
			int temp = a;
			a = b;
			b = temp;
		}

		if (a % b == 0) {
			return b;
		}

		return gcd(a % b, b);
	}
}