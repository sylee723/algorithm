package boj.p5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj5373_큐빙 {
	static char[][] U, D, F, B, L, R;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		U = new char[3][3];
		D = new char[3][3];
		F = new char[3][3];
		B = new char[3][3];
		L = new char[3][3];
		R = new char[3][3];

		for (int tc = 0; tc < TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			initCube();

			String[] turnCmd = br.readLine().split(" ");
			char[] line = new char[12];
			for (int n = 0; n < N; n++) {
				switch (turnCmd[n].charAt(0)) {
				case 'U':
					line[0] = B[0][2];
					line[1] = B[0][1];
					line[2] = B[0][0];

					line[3] = R[0][2];
					line[4] = R[0][1];
					line[5] = R[0][0];

					line[6] = F[0][2];
					line[7] = F[0][1];
					line[8] = F[0][0];

					line[9] = L[0][2];
					line[10] = L[0][1];
					line[11] = L[0][0];

					if (turnCmd[n].charAt(1) == '+') {
						line = turnRight(U, line);
					} else {
						line = turnRight(U, line);
						line = turnRight(U, line);
						line = turnRight(U, line);
					}

					B[0][2] = line[0];
					B[0][1] = line[1];
					B[0][0] = line[2];

					R[0][2] = line[3];
					R[0][1] = line[4];
					R[0][0] = line[5];

					F[0][2] = line[6];
					F[0][1] = line[7];
					F[0][0] = line[8];

					L[0][2] = line[9];
					L[0][1] = line[10];
					L[0][0] = line[11];

					break;

				case 'D':
					line[0] = B[2][0];
					line[1] = B[2][1];
					line[2] = B[2][2];

					line[3] = L[2][0];
					line[4] = L[2][1];
					line[5] = L[2][2];

					line[6] = F[2][0];
					line[7] = F[2][1];
					line[8] = F[2][2];

					line[9] = R[2][0];
					line[10] = R[2][1];
					line[11] = R[2][2];

					if (turnCmd[n].charAt(1) == '+') {
						line = turnRight(D, line);
					} else {
						line = turnRight(D, line);
						line = turnRight(D, line);
						line = turnRight(D, line);
					}

					B[2][0] = line[0];
					B[2][1] = line[1];
					B[2][2] = line[2];

					L[2][0] = line[3];
					L[2][1] = line[4];
					L[2][2] = line[5];

					F[2][0] = line[6];
					F[2][1] = line[7];
					F[2][2] = line[8];

					R[2][0] = line[9];
					R[2][1] = line[10];
					R[2][2] = line[11];

					break;

				case 'F':
					line[0] = U[2][0];
					line[1] = U[2][1];
					line[2] = U[2][2];

					line[3] = R[0][0];
					line[4] = R[1][0];
					line[5] = R[2][0];

					line[6] = D[2][0];
					line[7] = D[2][1];
					line[8] = D[2][2];

					line[9] = L[2][2];
					line[10] = L[1][2];
					line[11] = L[0][2];

					if (turnCmd[n].charAt(1) == '+') {
						line = turnRight(F, line);
					} else {
						line = turnRight(F, line);
						line = turnRight(F, line);
						line = turnRight(F, line);
					}

					U[2][0] = line[0];
					U[2][1] = line[1];
					U[2][2] = line[2];

					R[0][0] = line[3];
					R[1][0] = line[4];
					R[2][0] = line[5];

					D[2][0] = line[6];
					D[2][1] = line[7];
					D[2][2] = line[8];

					L[2][2] = line[9];
					L[1][2] = line[10];
					L[0][2] = line[11];

					break;

				case 'B':
					line[0] = U[0][2];
					line[1] = U[0][1];
					line[2] = U[0][0];

					line[3] = L[0][0];
					line[4] = L[1][0];
					line[5] = L[2][0];

					line[6] = D[0][2];
					line[7] = D[0][1];
					line[8] = D[0][0];

					line[9] = R[2][2];
					line[10] = R[1][2];
					line[11] = R[0][2];

					if (turnCmd[n].charAt(1) == '+') {
						line = turnRight(B, line);
					} else {
						line = turnRight(B, line);
						line = turnRight(B, line);
						line = turnRight(B, line);
					}

					U[0][2] = line[0];
					U[0][1] = line[1];
					U[0][0] = line[2];

					L[0][0] = line[3];
					L[1][0] = line[4];
					L[2][0] = line[5];

					D[0][2] = line[6];
					D[0][1] = line[7];
					D[0][0] = line[8];

					R[2][2] = line[9];
					R[1][2] = line[10];
					R[0][2] = line[11];

					break;

				case 'L':
					line[0] = U[0][0];
					line[1] = U[1][0];
					line[2] = U[2][0];

					line[3] = F[0][0];
					line[4] = F[1][0];
					line[5] = F[2][0];

					line[6] = D[2][2];
					line[7] = D[1][2];
					line[8] = D[0][2];

					line[9] = B[2][2];
					line[10] = B[1][2];
					line[11] = B[0][2];

					if (turnCmd[n].charAt(1) == '+') {
						line = turnRight(L, line);
					} else {
						line = turnRight(L, line);
						line = turnRight(L, line);
						line = turnRight(L, line);
					}

					U[0][0] = line[0];
					U[1][0] = line[1];
					U[2][0] = line[2];

					F[0][0] = line[3];
					F[1][0] = line[4];
					F[2][0] = line[5];

					D[2][2] = line[6];
					D[1][2] = line[7];
					D[0][2] = line[8];

					B[2][2] = line[9];
					B[1][2] = line[10];
					B[0][2] = line[11];

					break;

				case 'R':
					line[0] = U[2][2];
					line[1] = U[1][2];
					line[2] = U[0][2];

					line[3] = B[0][0];
					line[4] = B[1][0];
					line[5] = B[2][0];

					line[6] = D[0][0];
					line[7] = D[1][0];
					line[8] = D[2][0];

					line[9] = F[2][2];
					line[10] = F[1][2];
					line[11] = F[0][2];

					if (turnCmd[n].charAt(1) == '+') {
						line = turnRight(R, line);
					} else {
						line = turnRight(R, line);
						line = turnRight(R, line);
						line = turnRight(R, line);
					}

					U[2][2] = line[0];
					U[1][2] = line[1];
					U[0][2] = line[2];

					B[0][0] = line[3];
					B[1][0] = line[4];
					B[2][0] = line[5];

					D[0][0] = line[6];
					D[1][0] = line[7];
					D[2][0] = line[8];

					F[2][2] = line[9];
					F[1][2] = line[10];
					F[0][2] = line[11];

					break;
				}

			}

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.print(U[i][j]);
				}
				System.out.println();
			}
		}
	}

	static void initCube() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				U[i][j] = 'w';
				D[i][j] = 'y';
				F[i][j] = 'r';
				B[i][j] = 'o';
				L[i][j] = 'g';
				R[i][j] = 'b';
			}
		}
	}

	static char[] turnRight(char[][] square, char[] line) {
		char temp = square[0][0];
		square[0][0] = square[2][0];
		square[2][0] = square[2][2];
		square[2][2] = square[0][2];
		square[0][2] = temp;

		temp = square[0][1];
		square[0][1] = square[1][0];
		square[1][0] = square[2][1];
		square[2][1] = square[1][2];
		square[1][2] = temp;

		char[] result = new char[12];
		for (int i = 0; i < 12; i++) {
			result[i] = line[(i + 9) % 12];
		}

		return result;
	}
}
