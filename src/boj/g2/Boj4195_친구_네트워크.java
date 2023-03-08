package boj.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 시간 초과
public class Boj4195_친구_네트워크 {
	static Map<String, String> disjoint;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; tc++) {
			int F = Integer.parseInt(br.readLine());
			disjoint = new HashMap<>();

			for (int f = 0; f < F; f++) {
				st = new StringTokenizer(br.readLine());

				String a = st.nextToken();
				String b = st.nextToken();

				if (!disjoint.containsKey(a)) {
					disjoint.put(a, a);
				}
				if (!disjoint.containsKey(b)) {
					disjoint.put(b, b);
				}

				union(a, b);

				int count = 0;
				String r1 = findSet(a);
				for (String key : disjoint.keySet()) {
					String r2 = findSet(key);
					if (r2.equals(r1))
						count++;
				}
				System.out.println(count);
			}
		}
	}

	private static void union(String a, String b) {
		String p1 = findSet(a);
		String p2 = findSet(b);

		if (p1.equals(p2))
			return;

		disjoint.put(p1, p2);
	}

	private static String findSet(String a) {
		if (disjoint.get(a).equals(a))
			return a;
		
		disjoint.put(a, findSet(disjoint.get(a)));
		return disjoint.get(a);
	}
}
