import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Long n = sc.nextLong();

		int f;
		if (n <= 2) {
			f = 1;
		} else {
			int[][] arr = { { 1, 1 }, { 1, 0 } };
			int[][] answer = power(arr, n - 2);

			f = (answer[0][0] + answer[0][1]) % 1000000007;
		}

		System.out.println(f);
	}

	private static int[][] power(int[][] arr, long exp) {
		if (exp == 1) {
			return arr;
		}

		int[][] ret = power(arr, exp / 2);
		ret = multiply(ret, ret);
		if (exp % 2 != 0) {
			ret = multiply(ret, arr);
		}

		return ret;
	}

	private static int[][] multiply(int[][] arr1, int[][] arr2) {
		int[][] result = new int[2][2];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				long sum = 0L;
				for (int k = 0; k < 2; k++) {
					sum += (long) arr1[i][k] * arr2[k][j];
				}
				sum %= 1000000007;
				result[i][j] = (int) sum;
			}
		}

		return result;
	}
}