package boj.s1;

import java.util.Arrays;
import java.util.Scanner;

public class Boj1931_회의실_배정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		Meeting[] meeting = new Meeting[N];

		for (int n = 0; n < N; n++) {
			meeting[n] = new Meeting(sc.nextInt(), sc.nextInt());
		}

		Arrays.sort(meeting); // 회의 끝나는 시간이 빠른 순,끝나는 시간이 같으면 시작 시간으로 정렬

		Meeting previous = meeting[0];
		int count = 1;
		for (int i = 1; i < N; i++) {
			if (previous.end <= meeting[i].start) {
				count++;
				previous = meeting[i];
			}
		}

		System.out.println(count);
	}

	static class Meeting implements Comparable<Meeting> {
		int start, end;

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			if (this.end == o.end)
				return Integer.compare(this.start, o.start);
			return Integer.compare(this.end, o.end);
		}

		@Override
		public String toString() {
			return "Meeting [start=" + start + ", end=" + end + "]";
		}
	}
}
