package boj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

//듣보잡
public class Boj1764 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Set<String> peopleA = new HashSet<>();
		Set<String> peopleB = new HashSet<>();

		for (int n = 0; n < N; n++) {
			peopleA.add(br.readLine());
		}
		for (int m = 0; m < M; m++) {
			peopleB.add(br.readLine());
		}

		List<String> result = new ArrayList<>();
		for (String person : peopleA) {
			if (peopleB.contains(person))
				result.add(person);
		}
		Collections.sort(result);
		System.out.println(result.size());
		for (String r : result)
			System.out.println(r);
	}
}
