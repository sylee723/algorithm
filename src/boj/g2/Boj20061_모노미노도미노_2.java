package boj.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj20061_모노미노도미노_2 {
	static boolean[][] blue = new boolean[4][6];
	static boolean[][] green = new boolean[6][4];
	static int score;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		score = 0;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			moveToBlue(t, x, y);
			moveToGreen(t, x, y);

			checkBlueCol();
			checkGreenRow();

			specialBlue();
			specialGreen();
		}

		int count = 0;
		for (int i = 0; i < blue.length; i++) {
			for (int j = 0; j < blue[0].length; j++) {
				if (blue[i][j]) {
					count++;
				}
			}
		}
		for (int i = 0; i < green.length; i++) {
			for (int j = 0; j < green[0].length; j++) {
				if (green[i][j]) {
					count++;
				}
			}
		}

		System.out.println(score);
		System.out.println(count);
	}

	private static void moveToBlue(int t, int x, int y) {
		int j = 0;

		switch (t) {
		case 1:
			while (j < blue[x].length && !blue[x][j]) {
				j++;
			}
			blue[x][j - 1] = true;
			break;
		case 2:
			while (j < blue[x].length && !blue[x][j]) {
				j++;
			}
			blue[x][j - 1] = true;
			blue[x][j - 2] = true;
			break;
		case 3:
			while (j < blue[x].length && !blue[x][j] && !blue[x + 1][j]) {
				j++;
			}
			blue[x][j - 1] = true;
			blue[x + 1][j - 1] = true;
			break;
		}
	}

	private static void moveToGreen(int t, int x, int y) {
		int i = 0;

		switch (t) {
		case 1:
			while (i < green.length && !green[i][y]) {
				i++;
			}
			green[i - 1][y] = true;
			break;
		case 2:
			while (i < green.length && !green[i][y] && !green[i][y + 1]) {
				i++;
			}
			green[i - 1][y] = true;
			green[i - 1][y + 1] = true;
			break;
		case 3:
			while (i < green.length && !green[i][y]) {
				i++;
			}
			green[i - 1][y] = true;
			green[i - 2][y] = true;
			break;
		}
	}

	private static void checkBlueCol() {
		int col = blue[0].length - 1;
		while (col >= 0) {
			boolean full = true;
			for (int i = 0; i < blue.length; i++) {
				if (!blue[i][col]) {
					full = false;
					break;
				}
			}

			if (full) {
				score++;
				for (int j = col; j > 0; j--) {
					for (int i = 0; i < blue.length; i++) {
						blue[i][j] = blue[i][j - 1];
					}
				}
				col++;
			}
			col--;
		}
	}

	private static void checkGreenRow() {
		int row = green.length - 1;
		while (row >= 0) {
			boolean full = true;
			for (int j = 0; j < green[0].length; j++) {
				if (!green[row][j]) {
					full = false;
					break;
				}
			}

			if (full) {
				score++;
				for (int i = row; i > 0; i--) {
					for (int j = 0; j < green[0].length; j++) {
						green[i][j] = green[i - 1][j];
					}
				}
				row++;
			}
			row--;
		}
	}

	private static void specialBlue() {
		int moveCnt = 0;
		for (int j = 0; j <= 1; j++) {
			for (int i = 0; i < blue.length; i++) {
				if (blue[i][j]) {
					moveCnt++;
					break;
				}
			}
		}

		if (moveCnt > 0) {
			for (int j = blue[0].length - 1; j - moveCnt >= 0; j--) {
				for (int i = 0; i < blue.length; i++) {
					blue[i][j] = blue[i][j - moveCnt];
				}
			}

			for (int j = 0; j <= 1; j++) {
				for (int i = 0; i < blue.length; i++) {
					if (blue[i][j]) {
						blue[i][j] = false;
					}
				}
			}
		}
	}

	private static void specialGreen() {
		int moveCnt = 0;
		for (int i = 0; i <= 1; i++) {
			for (int j = 0; j < green[0].length; j++) {
				if (green[i][j]) {
					moveCnt++;
					break;
				}
			}
		}

		if (moveCnt > 0) {
			for (int i = green.length - 1; i - moveCnt >= 0; i--) {
				for (int j = 0; j < green[0].length; j++) {
					green[i][j] = green[i - moveCnt][j];
				}
			}

			for (int i = 0; i <= 1; i++) {
				for (int j = 0; j < green[0].length; j++) {
					if (green[i][j]) {
						green[i][j] = false;
					}
				}
			}
		}
	}

}
