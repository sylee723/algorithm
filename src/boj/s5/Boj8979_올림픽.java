package boj.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj8979_올림픽 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		PriorityQueue<Country> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new Country(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		int[] medal = new int[3];
		int count = 1;
		int rank = 0;
		Country now = null;
		while (!pq.isEmpty()) {
			now = pq.poll();
			
			if (medal[0] == now.gold && medal[1] == now.silver && medal[2] == now.bronze) {
				count++;
			} else {
				rank += count;
				medal[0] = now.gold;
				medal[1] = now.silver;
				medal[2] = now.bronze;

				count = 1;
			}

			if (now.num == K) {
				System.out.println(rank);
				break;
			}
		}
	}

	static class Country implements Comparable<Country> {
		int num, gold, silver, bronze;

		public Country(int num, int gold, int silver, int bronze) {
			this.num = num;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}

		@Override
		public String toString() {
			return "Country [num=" + num + ", gold=" + gold + ", silver=" + silver + ", bronze=" + bronze + "]";
		}

		@Override
		public int compareTo(Country o) {
			if (this.gold == o.gold) {
				if (this.silver == o.silver) {
					if (this.bronze == o.bronze) {
						return this.num - o.num;
					}
					return -(this.bronze - o.bronze);
				}
				return -(this.silver - o.silver);
			}
			return -(this.gold - o.gold);
		}

	}
}
