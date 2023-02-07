package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Flatten
public class Swea1208 {
	static int[] boxes;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int dump_num = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			boxes = new int[100];
			for (int i = 0; i < 100; i++) {
				boxes[i] = Integer.parseInt(st.nextToken());
			}
			int result = 0;
			for (int n = 0; n < dump_num; n++) {
				result = dump();
				if (result <= 1)
					break;
			}
			System.out.println("#" + tc + " " + result);
		}
	}

	static int dump() {
		int[] idx = getMaxMinIdx();
		boxes[idx[1]]--;
		boxes[idx[0]]++;
		idx = getMaxMinIdx();
		return boxes[idx[1]] - boxes[idx[0]];
	}

	static int[] getMaxMinIdx() {
		int[] idx = new int[2];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int min_idx = 0, max_idx = 0;
		for (int i = 0; i < boxes.length; i++) {
			if (boxes[i] < min) {
				min = boxes[i];
				min_idx = i;
			}
			if (boxes[i] > max) {
				max = boxes[i];
				max_idx = i;
			}
		}
		idx[0] = min_idx;
		idx[1] = max_idx;
		return idx;
	}
}
