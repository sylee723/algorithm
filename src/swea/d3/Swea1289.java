package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//원재의 메모리 복구하기
public class Swea1289 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String line = br.readLine();
			int[] memory = new int[line.length()];
			for (int i = 0; i < line.length(); i++) {
				memory[i] = line.charAt(i) - '0';
			}

			int count = 0;
			int bit = memory[0];
			if (bit == 1)
				count++;
			for (int i = 1; i < memory.length; i++) {
				if (memory[i] != bit) {
					count++;
					bit = memory[i];
				}
			}
			System.out.println("#" + t + " " + count);
		}
	}
}
