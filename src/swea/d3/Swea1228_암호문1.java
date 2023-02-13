package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Swea1228_암호문1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<Integer> numList = new ArrayList<>();
			for (int n = 0; n < N; n++) {
				numList.add(Integer.parseInt(st.nextToken()));
			}

			int command_N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < command_N; n++) {
				st.nextToken(); // I
				int x = Integer.parseInt(st.nextToken()); // 넣을 위치
				int y = Integer.parseInt(st.nextToken());
				for (int i = 0; i < y; i++) {
					numList.add(x, Integer.parseInt(st.nextToken()));
					x++;
				}
			}

			System.out.print("#" + tc + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(numList.get(i) + " ");
			}
			System.out.println();
		}
	}
}
