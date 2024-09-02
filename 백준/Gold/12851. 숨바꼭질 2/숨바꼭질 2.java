import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int minTime, count;
	static int MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		MAX_VALUE = 100000;
		minTime = MAX_VALUE + 1;
		count = 0;
		bfs(N, K);

		System.out.println(minTime);
		System.out.println(count);
	}

	private static void bfs(int start, int dest) {
		Queue<Integer> queue = new ArrayDeque<>();
		int[] visited = new int[MAX_VALUE + 1];
		Arrays.fill(visited, MAX_VALUE + 1);
		visited[start] = 0;
		queue.add(start);

		int time = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				int now = queue.poll();
				if (now == dest) {
					minTime = time;
					count++;
					continue;
				}

				int next = now - 1;
				if (next >= 0 && visited[next] >= time) {
					visited[next] = time;
					queue.add(next);
				}

				next = now + 1;
				if (next <= MAX_VALUE && visited[next] >= time) {
					visited[next] = time;
					queue.add(next);
				}

				next = now * 2;
				if (next <= MAX_VALUE && visited[next] >= time) {
					visited[next] = time;
					queue.add(next);
				}
			}

			time++;
			if (time > minTime) {
				break;
			}
		}
	}
}