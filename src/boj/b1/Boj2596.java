package boj.b1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2596 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String line = br.readLine();
		char[][] diary = new char[T][6];

		for (int i = 0; i < T; i++) {
			for (int j = 0; j < 6; j++) {
				diary[i][j] = line.charAt(6 * i + j);
			}
		}

		// 문자를 나타내는 6개의 문자열을 저장하는 배열
		String[] code = { "000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010" };
		char[] LETTER = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };
		String result = ""; // 출력할 문자열을 저장
		boolean output_str = true; // 출력 결과가 문자열이면 true, 모르는 문자가 나오면 false
		
		for (int i = 0; i < T; i++) { // 각 문자에 대해
			int[] count_wrong = new int[8]; // 각 문자별로 보낸 코드와 다른  개수 카운트
			for (int j = 0; j < 6; j++) {
				for (int d = 0; d < code.length; d++) {
					if (diary[i][j] != code[d].charAt(j))
						count_wrong[d]++;
				}
			}
			
//			System.out.println(Arrays.toString(count_wrong));

			boolean understand = false;
			for (int d = 0; d < code.length; d++) {
				if (count_wrong[d] <= 1) { // 코드 한 개 이하로 잘못 오면 인식 가능
					result += LETTER[d];
					understand = true;
					break;
				}
			}
			if (!understand) { // 모르는 문자가 들어온 경우
				System.out.println(i + 1); // 모르는 문자가 처음 나오는 위치 출력
				output_str = false;
				break;
			}

		}
		if (output_str)
			System.out.println(result); // 이해한 문자를 출력

	}

}