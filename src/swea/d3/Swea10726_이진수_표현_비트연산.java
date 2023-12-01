package swea.d3;

import java.util.Scanner;

public class Swea10726_이진수_표현_비트연산 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			String answer;

//			boolean result = true;
//			for (int n = 0; n < N; n++) {
//				if ((M & (1 << n)) == 0) {
//					result = false;
//					break;
//				}
//			}
//			if (result)
//				answer = "ON";
//			else
//				answer = "OFF";

///////////////////////////////////////////////////////////			

			int lastNBit = (1 << N) - 1; // 111...1 (길이 N)

			if (lastNBit == (M & lastNBit))
				answer = "ON";
			else
				answer = "OFF";

			System.out.println("#" + tc + " " + answer);
		}
	}
}
