package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Swea1230_암호문3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> numList = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				numList.add(Integer.parseInt(st.nextToken()));
			} // 원본 암호문 입력

			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				char cmd = st.nextToken().charAt(0);
				int x, y, s;
				switch (cmd) {
				case 'I':
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());

					for (int i = x; i < x + y; i++) {
						s = Integer.parseInt(st.nextToken());
						numList.add(i, s);
					}
					break;
				case 'D':
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());

					for (int i = 0; i < y; i++) {
						numList.remove(x);
					}
					break;
				case 'A':
					y = Integer.parseInt(st.nextToken());

					for (int i = 0; i < y; i++) {
						s = Integer.parseInt(st.nextToken());
						numList.add(s);
					}
					break;
				}
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 10; i++) {
				sb.append(numList.get(i)).append(" ");
			}
			System.out.println("#" + tc + " " + sb);
		}
	}
}
