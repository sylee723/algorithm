package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj9017_크로스_컨트리 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] team = new int[N];
			int[] count = new int[201];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				team[i] = Integer.parseInt(st.nextToken());
				count[team[i]]++;
			}

			Map<Integer, Integer> scoreSum = new HashMap<>();
			Map<Integer, ArrayList<Integer>> scoreList = new HashMap<>();
			for (int i = 1; i <= 200; i++) {
				if (count[i] == 6) {
					scoreSum.put(i, 0);
					scoreList.put(i, new ArrayList<>());
				}
			}

			int rank = 1;
			for (int i = 0; i < N; i++) {
				if (scoreSum.containsKey(team[i])) {
					ArrayList<Integer> scores = scoreList.get(team[i]);
					scores.add(rank);
					scoreList.put(team[i], scores);

					if (scores.size() <= 4) {
						scoreSum.put(team[i], scoreSum.get(team[i]) + rank);
					}

					rank++;
				}
			}

			int teamNum = 0;
			int minScore = Integer.MAX_VALUE;
			for (int key : scoreSum.keySet()) {
				int score = scoreSum.get(key);
				if (score < minScore) {
					teamNum = key;
					minScore = score;
				} else if (score == minScore) {
					int teamA = scoreList.get(teamNum).get(4);
					int teamB = scoreList.get(key).get(4);

					teamNum = (teamA < teamB) ? teamNum : key;
				}
			}

			System.out.println(teamNum);
		}
	}
}
