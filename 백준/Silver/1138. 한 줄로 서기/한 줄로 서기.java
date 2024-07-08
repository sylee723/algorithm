import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] leftCnt = new int[N];
		for (int i = 0; i < N; i++) {
			leftCnt[i] = sc.nextInt();
		}

		int[] answer = new int[N];
		for (int i = 0; i < N; i++) {
			int num = i + 1;
			int count = leftCnt[i];
			int nowCnt = 0;
			int idx = 0;

			while (nowCnt < count) {
				if (answer[idx] == 0) {
					nowCnt++;
				}
				idx++;
			}

			while (answer[idx] != 0) {
				idx++;
			}

			answer[idx] = num;
		}

		for (int i = 0; i < N; i++) {
			System.out.print(answer[i] + " ");
		}
	}
}