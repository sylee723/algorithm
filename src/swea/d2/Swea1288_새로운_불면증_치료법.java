package swea.d2;

import java.util.Scanner;

public class Swea1288_새로운_불면증_치료법 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			boolean[] num_check = new boolean[10];

			int x = 1;
			int count = 0;
			while (true) {
				int temp = N * x;
				while (temp > 0) {
					int i = temp % 10;
					temp /= 10;

					if (num_check[i] == false) {
						num_check[i] = true;
						count++;
					}
				}

				if (count == 10)
					break;
				x++;
			}

			System.out.println("#" + t + " " + N * x);
		}
	}
}
