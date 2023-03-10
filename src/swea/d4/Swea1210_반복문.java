package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Ladder1
public class Swea1210_반복문 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int tc = Integer.parseInt(br.readLine());
			int[][] data = new int[100][100];
			int now = 0;
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					data[i][j] = Integer.parseInt(st.nextToken());
					if (data[i][j] == 2) {
						now = j;
					}
				}
			} // input

			for (int i = 99; i >= 0; i--) { // 한 줄씩 위로 이동
				if (now - 1 >= 0 && data[i][now - 1] == 1) { // 왼쪽 방향 확인
					now--;
					while (data[i - 1][now] != 1) { // 세로 막대를 만날 때까지 이동
						now--;
					}
				} else if (now + 1 <= 99 && data[i][now + 1] == 1) { // 오른쪽 방향 확인
					now++;
					while (data[i - 1][now] != 1) { // 세로 막대를 만날 때까지 이동
						now++;
					}
				} 
			}
			
			System.out.println("#" + tc + " " + now);
		} // test case
	}
}