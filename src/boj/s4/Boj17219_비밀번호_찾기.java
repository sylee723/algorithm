package boj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj17219_비밀번호_찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<String, String> password = new HashMap<String, String>();

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			password.put(st.nextToken(), st.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		for (int m = 0; m < M; m++) {
			String site = br.readLine();
			sb.append(password.get(site)).append('\n');
		}
		System.out.println(sb);
	}
}
