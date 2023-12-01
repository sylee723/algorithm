package boj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj20529_가장_가까운_세_사람의_심리적_거리 {
	static int min;
	static String[] selected;
	static Map<String, Integer> map;
	static String[] type = { "ISTJ", "ISFJ", "INFJ", "INTJ", "ISTP", "ISFP", "INFP", "INTP", "ESTP", "ESFP", "ENFP",
			"ENTP", "ESTJ", "ESFJ", "ENFJ", "ENTJ" };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		map = new HashMap<>();
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			map.clear();

			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line);
			int answer = -1;
			for (int n = 0; n < N; n++) {
				String mbti = st.nextToken();

				if (map.containsKey(mbti)) {
					map.put(mbti, map.get(mbti) + 1);

					if (map.get(mbti).equals(3)) {
						answer = 0;
						break;
					}
				} else {
					map.put(mbti, 1);
				}
			}

			if (answer == -1) {
				min = Integer.MAX_VALUE;
				selected = new String[3];
				comb(0);
				answer = min;
			}
			System.out.println(answer);
		}
	}

	private static void comb(int idx) {
		if (idx == 3) {
			int distance = getDistance(selected[0], selected[1]);
			distance += getDistance(selected[1], selected[2]);
			distance += getDistance(selected[2], selected[0]);
			min = Math.min(min, distance);
			return;
		}
		for (int k = 0; k < 16; k++) {
			if (map.containsKey(type[k]) && map.get(type[k]) > 0) {
				selected[idx] = type[k];
				map.put(type[k], map.get(type[k]) - 1);
				comb(idx + 1);
				map.put(type[k], map.get(type[k]) + 1);
			}
		}
	}

	private static int getDistance(String type1, String type2) {
		int d = 0;
		for (int i = 0; i < 4; i++) {
			if (type1.charAt(i) != type2.charAt(i))
				d++;
		}
		return d;
	}

}
