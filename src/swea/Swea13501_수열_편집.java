package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Swea13501_수열_편집 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			ArrayList<Integer> numList = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				numList.add(Integer.parseInt(st.nextToken()));
			}

			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				char cmd = st.nextToken().charAt(0);

				int x, y;
				if (cmd == 'I') {
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					numList.add(x, y);
				} else if (cmd == 'D') {
					x = Integer.parseInt(st.nextToken());
					numList.remove(x);
				} else if (cmd == 'C') {
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					numList.remove(x);
					numList.add(x, y);
				}
			}

			int answer;
			if (numList.size() <= L)
				answer = -1;
			else
				answer = numList.get(L);

			System.out.println("#" + t + " " + answer);
		}
	}
}
