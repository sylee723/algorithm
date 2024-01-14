package boj.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj10431_줄세우기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int P = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> student = new ArrayList<>();
		int answer;

		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());

			sb.append(st.nextToken()).append(" ");
			student.clear();
			answer = 0;

			for (int j = 0; j < 20; j++) {
				int height = Integer.parseInt(st.nextToken());
				if (student.isEmpty() || student.get(student.size() - 1) < height) {
					student.add(height);
				} else {
					int idx = j - 1;
					while (idx >= 0 && height < student.get(idx)) {
						idx--;
					}
					student.add(idx + 1, height);

					answer += j - (idx + 1);
				}
			}
			sb.append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}
}
