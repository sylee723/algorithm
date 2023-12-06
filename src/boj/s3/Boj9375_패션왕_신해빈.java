package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj9375_패션왕_신해빈 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Map<String, Integer> map = new HashMap<>();

		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			map.clear();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				String type = st.nextToken();

				if (map.containsKey(type)) {
					map.put(type, map.get(type) + 1);
				} else {
					map.put(type, 1);
				}
			}

			int answer = 1;
			for (String key : map.keySet()) {
				answer *= (map.get(key) + 1);
			}
			System.out.println(answer - 1);
		}
	}
}
