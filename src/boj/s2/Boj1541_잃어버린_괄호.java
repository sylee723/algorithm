package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj1541_잃어버린_괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		int si;
		int idx = 0;
		ArrayList<Integer> numList = new ArrayList<>();
		ArrayList<Character> opList = new ArrayList<>();

		while (idx < input.length()) {
			si = idx;
			while (idx < input.length() && (input.charAt(idx) >= '0' && input.charAt(idx) <= '9')) {
				idx++;
			}
			int num = Integer.parseInt(input.substring(si, idx));
			numList.add(num);

			if (idx < input.length() && (input.charAt(idx) == '+' || input.charAt(idx) == '-')) {
				opList.add(input.charAt(idx));
			}
			idx++;
		}

//		System.out.println(numList);
//		System.out.println(opList);

		int answer = numList.get(0);

		for (int i = 0; i < opList.size(); i++) {
			if (opList.get(i) == '+') {
				answer += numList.get(i + 1);
			} else { // - 가 나오면
				for (int j = i + 1; j < numList.size(); j++) { // 나머지 수 다 마이너스
					answer -= numList.get(j);
				}
				break;
			}
		}

		System.out.println(answer);
	}
}
