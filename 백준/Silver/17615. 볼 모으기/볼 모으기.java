import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] ball = br.readLine().toCharArray();

		// 오른쪽으로 이동
		int redCnt = 0;
		int blueCnt = 0;
		boolean moveRed = false;
		boolean moveBlue = false;
		for (int i = N - 1; i >= 0; i--) {
			if (!moveRed && ball[i] == 'B') {
				moveRed = true;
			}
			if (!moveBlue && ball[i] == 'R') {
				moveBlue = true;
			}

			if (moveRed && ball[i] == 'R') {
				redCnt++;
			}
			if (moveBlue && ball[i] == 'B') {
				blueCnt++;
			}
		}
		int answer = Math.min(redCnt, blueCnt);

		// 왼쪽으로 이동
		redCnt = 0;
		blueCnt = 0;
		moveRed = false;
		moveBlue = false;
		for (int i = 0; i < N; i++) {
			if (!moveRed && ball[i] == 'B') {
				moveRed = true;
			}
			if (!moveBlue && ball[i] == 'R') {
				moveBlue = true;
			}

			if (moveRed && ball[i] == 'R') {
				redCnt++;
			}
			if (moveBlue && ball[i] == 'B') {
				blueCnt++;
			}
		}
		answer = Math.min(answer, redCnt);
		answer = Math.min(answer, blueCnt);

		System.out.println(answer);
	}
}