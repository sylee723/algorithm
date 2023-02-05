package boj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//나는야 포켓몬 마스터 이다솜
public class Boj1620 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<Integer, String> pokemonMap_numKey = new HashMap<>();
		Map<String, Integer> pokemonMap_nameKey = new HashMap<>();
		for (int n = 1; n <= N; n++) {
			String name = br.readLine();
			pokemonMap_numKey.put(n, name);
			pokemonMap_nameKey.put(name, n);
		}
		for (int m = 0; m < M; m++) {
			String quiz = br.readLine();
			if (pokemonMap_nameKey.containsKey(quiz))
				System.out.println(pokemonMap_nameKey.get(quiz));
			else
				System.out.println(pokemonMap_numKey.get(Integer.parseInt(quiz)));
		}
	}
}
