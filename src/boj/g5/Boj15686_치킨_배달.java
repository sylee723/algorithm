package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj15686_치킨_배달 {
	static boolean[] selected;
	static int M, city_c_dist;
	static ArrayList<int[]> house, chicken;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		house = new ArrayList<>();
		chicken = new ArrayList<>();

		int cNum = 0;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == 1)
					house.add(new int[] { i, j });
				else if (temp == 2) {
					chicken.add(new int[] { i, j });
					cNum++;
				}
			}
		}

		selected = new boolean[cNum];
		city_c_dist = Integer.MAX_VALUE;
		comb(0, 0);

		System.out.println(city_c_dist);
	}

	static void comb(int idx, int cnt) {
		if (cnt == M) {
			int temp_city_c_dist = 0;
			for (int i = 0; i < house.size(); i++) {
				int c_dist = Integer.MAX_VALUE;
				for (int j = 0; j < chicken.size(); j++) {
					if (selected[j]) {
						int temp = Math.abs(house.get(i)[0] - chicken.get(j)[0])
								+ Math.abs(house.get(i)[1] - chicken.get(j)[1]);
						c_dist = Math.min(c_dist, temp);
					}
				}
				temp_city_c_dist += c_dist;
			}
			city_c_dist = Math.min(city_c_dist, temp_city_c_dist);
			return;
		}

		if (idx == selected.length)
			return;

		selected[idx] = true;
		comb(idx + 1, cnt + 1);
		selected[idx] = false;
		comb(idx + 1, cnt);
	}
}
