package boj.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj25757_임스와_함께하는_미니게임 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		char gameType = st.nextToken().charAt(0);
		Set<String> player = new HashSet<>();

		for (int i = 0; i < N; i++) {
			player.add(br.readLine());
		}

		int answer = 0;
		switch (gameType) {
		case 'Y':
			answer = player.size();
			break;
		case 'F':
			answer = player.size() / 2;
			break;
		case 'O':
			answer = player.size() / 3;
			break;
		}

		System.out.println(answer);
	}
}
