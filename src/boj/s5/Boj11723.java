package boj.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 집합
public class Boj11723 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int M = Integer.parseInt(br.readLine());
		int S = 0; // 공집합

		for (int m = 0; m < M; m++) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line);
			int num = 0;
			switch (st.nextToken()) {
			case "add":
				num = Integer.parseInt(st.nextToken());
				S = S | (1 << num);
				break;
			case "remove":
				num = Integer.parseInt(st.nextToken());
				S = S & ~(1 << num);
				break;
			case "check":
				num = Integer.parseInt(st.nextToken());
				if ((S & (1 << num)) != 0)
					sb.append("1\n");
				else
					sb.append("0\n");
				break;
			case "toggle":
				num = Integer.parseInt(st.nextToken());
				S = S ^ (1 << num);
				break;
			case "all":
				S = (1 << 21) - 1;
				break;
			case "empty":
				S = 0;
				break;
			}
		}
		System.out.println(sb);
	}
}
