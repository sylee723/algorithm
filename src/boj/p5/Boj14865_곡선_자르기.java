package boj.p5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 해결 못함
public class Boj14865_곡선_자르기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		List<Rectangle> rect = new ArrayList<>();

		int bx = 0;
		int by = 0;
		int sx;
		int sy;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (y == by && y > 0) {
				rect.add(new Rectangle(Math.min(x, bx), Math.max(x, bx), y));
			}
			bx = x;
			by = y;
		}
		Collections.sort(rect);
		int count1 = 0;
		int count2 = 0;
		for (int i = 0; i < rect.size(); i++) {
			Rectangle thisR = rect.get(i);
			boolean Contain = false;
			boolean isContained = false;
			for (int j = i + 1; j < rect.size(); j++) {
				if (i == j)
					continue;
				Rectangle otherR = rect.get(j);

				if (thisR.h > otherR.h) {
					if (thisR.sx < otherR.sx && thisR.bx > otherR.bx)
						Contain = true;
				} else if (thisR.h < otherR.h) {
					if (thisR.sx > otherR.sx && thisR.bx < otherR.bx)
						isContained = true;
				}
			}
			if (!isContained)
				count1++;
			if (!Contain)
				count2++;
		}

		System.out.println(count1 + " " + count2);
	}

	static class Rectangle implements Comparable<Rectangle> {
		int sx;
		int bx;
		int h;

		public Rectangle(int sx, int bx, int h) {
			super();
			this.sx = sx;
			this.bx = bx;
			this.h = h;
		}

		@Override
		public String toString() {
			return "Rectangle [sx=" + sx + ", bx=" + bx + ", h=" + h + "]";
		}

		@Override
		public int compareTo(Rectangle o) {
			if (this.h == o.h)
				return this.sx - o.sx;
			return o.h - this.h;
		}
	}
}
