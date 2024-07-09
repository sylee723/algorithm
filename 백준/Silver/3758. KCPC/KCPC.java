import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int tc = 0; tc < TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] score = new int[N + 1][K + 1];
			int[] submitCnt = new int[N + 1];
			int[] lastSubmit = new int[N + 1];

			for (int m = 1; m <= M; m++) {
				st = new StringTokenizer(br.readLine());
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());

				score[i][j] = Math.max(score[i][j], s);
				submitCnt[i]++;
				lastSubmit[i] = m;
			}

			System.out.println(getMyRank(N, T, score, submitCnt, lastSubmit));
		}
	}

	private static int getMyRank(int N, int myTeamNum, int[][] score, int[] submitCnt, int[] lastSubmit) {
		int[] scoreSum = new int[N + 1];

		PriorityQueue<Team> pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j < score[i].length; j++) {
				scoreSum[i] += score[i][j];
			}

			pq.add(new Team(i, scoreSum[i], submitCnt[i], lastSubmit[i]));
		}

		int rank = 1;
		while (!pq.isEmpty()) {
			Team now = pq.poll();
			if (now.num == myTeamNum) {
				break;
			}
			rank++;
		}

		return rank;
	}

	static class Team implements Comparable<Team> {
		int num, scoreSum, submitCnt, lastSubmit;

		public Team(int num, int scoreSum, int submitCnt, int lastSubmit) {
			this.num = num;
			this.scoreSum = scoreSum;
			this.submitCnt = submitCnt;
			this.lastSubmit = lastSubmit;
		}

		@Override
		public int compareTo(Team o) {
			if (this.scoreSum != o.scoreSum) {
				return -(this.scoreSum - o.scoreSum);
			} else if (this.submitCnt != o.submitCnt) {
				return this.submitCnt - o.submitCnt;
			} else {
				return this.lastSubmit - o.lastSubmit;
			}
		}
	}
}