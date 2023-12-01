package swea.d2;

import java.util.Scanner;

public class Swea1288_새로운_불면증_치료법_비트마스킹 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int end = (1 << 10) - 1; // 모든 숫자 0 ~ 9가 등장했을 때의 값

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int visited = 0; // 본 숫자를 비트 마스킹으로 나타냄
			int i = 1; // 현재 몇번 양 세고 있는지

			int now;
			while (true) {
				now = N * i;
				while (now > 0) {
					int r = now % 10;
					now /= 10;

					visited = visited | (1 << r); // 숫자가 등장했다는 의미로 bit를 1로 변경
				}

				if (visited == end) { // 모든 숫자가 등장했다면, 종료
					break;
				}
				i++;
			}
			System.out.println("#" + t + " " + N * i);
		}
	}
}
