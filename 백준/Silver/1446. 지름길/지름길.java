import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, D, minDist;
	static boolean[] selected;
	static Road[] road;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		road = new Road[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());

			road[i] = new Road(s, e, l);
		}

		Arrays.sort(road);
		selected = new boolean[N];
		minDist = D;
		subset(0);

		System.out.println(minDist);
	}

	private static void subset(int idx) {
		if (idx == N) {
			getDist();
			return;
		}

		selected[idx] = true;
		subset(idx + 1);
		selected[idx] = false;
		subset(idx + 1);
	}

	private static void getDist() {
		int now = 0;
		int distance = 0;

		for (int i = 0; i < N; i++) {
			if (!selected[i]) {
				continue;
			}

			Road r = road[i];
			if (now > r.start) {
				return;
			} else {
				distance += (r.start - now);
				now = r.end;
				distance += r.len;
			}
		}

		if (now > D || distance >= minDist) {
			return;
		} else {
			distance += (D - now);
			minDist = Math.min(distance, minDist);
		}
	}

	static class Road implements Comparable<Road> {
		int start, end, len;

		public Road(int start, int end, int len) {
			this.start = start;
			this.end = end;
			this.len = len;
		}

		@Override
		public int compareTo(Road o) {
			if (this.end == o.end) {
				return this.start - o.start;
			}
			return this.end - o.end;
		}
	}
}