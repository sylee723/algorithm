package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj7507_올림픽_게임 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int M = Integer.parseInt(br.readLine());
			int[][] game = new int[M][3];
			int days = 0;
			for (int m = 0; m < M; m++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				game[m][0] = Integer.parseInt(st.nextToken());
				game[m][1] = Integer.parseInt(st.nextToken());
				game[m][2] = Integer.parseInt(st.nextToken());

				days = Math.max(days, game[m][0]); // 경기가 며칠까지 있는지
			}
			Arrays.sort(game, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[0] == o2[0])
						return o1[2] - o2[2];
					return o1[0] - o2[0];
				}

			});
			for (int i = 0; i < M; i++) {
				System.out.println(Arrays.toString(game[i]));
			}
			int i =0;
			int day = game[0][0];
			int[] count = new int[days + 1];
			while(true) {
				if (day != game[i][0])
					day = game[i][0];
				
				
				count[day]++;
			}
			System.out.println("Scenario #" + t + ":");
		}
	}
}
