package boj.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj4195_친구_네트워크 {
	static Map<String, String> disjoint;
	static Map<String, Set<String>> network;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());
		disjoint = new HashMap<>();
		network = new HashMap<>();

		for (int tc = 0; tc < TC; tc++) {
			int F = Integer.parseInt(br.readLine());
			disjoint.clear();
			network.clear();

			for (int f = 0; f < F; f++) {
				st = new StringTokenizer(br.readLine());

				String f1 = st.nextToken();
				String f2 = st.nextToken();

				if (!disjoint.containsKey(f1)) {
					disjoint.put(f1, f1);
					Set<String> set = new HashSet<>();
					set.add(f1);
					network.put(f1, set);
				}
				if (!disjoint.containsKey(f2)) {
					disjoint.put(f2, f2);
					Set<String> set = new HashSet<>();
					set.add(f2);
					network.put(f2, set);
				}

				union(f1, f2);
				String key = findSet(f1);

				sb.append(network.get(key).size()).append("\n");
			}
		}

		System.out.println(sb.toString());
	}

	private static String findSet(String f1) {
		if (disjoint.get(f1).equals(f1)) {
			return f1;
		}

		disjoint.put(f1, findSet(disjoint.get(f1)));
		return disjoint.get(f1);
	}

	private static void union(String f1, String f2) {
		String r1 = findSet(f1);
		String r2 = findSet(f2);

		if (r1.equals(r2)) {
			return;
		}

		disjoint.put(r2, r1);
		Set<String> s1 = network.get(r1);
		Set<String> s2 = network.get(r2);

		s1.addAll(s2);
		network.put(r1, s1);
		network.remove(r2);
	}
}
