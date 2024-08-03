import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int P = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Player> input = new ArrayList<>();
		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			String n = st.nextToken();
			input.add(new Player(n, l));
		}

		ArrayList<Player> roomInfo = new ArrayList<>();
		Map<String, PriorityQueue<Player>> roomMember = new HashMap<>();
		for (Player player : input) {
			boolean enter = false;
			for (Player first : roomInfo) { // 들어갈 방이 있는지 확인
				if (first.level - 10 <= player.level && player.level <= first.level + 10
						&& roomMember.get(first.nickname).size() < M) {
					PriorityQueue<Player> members = roomMember.get(first.nickname);
					members.add(player);
					enter = true;
					break;
				}
			}

			if (!enter) {
				roomInfo.add(player);
				PriorityQueue<Player> pq = new PriorityQueue<>();
				pq.add(player);
				roomMember.put(player.nickname, pq);
			}
		}

		for (Player first : roomInfo) {
			PriorityQueue<Player> members = roomMember.get(first.nickname);
			if (members.size() == M) {
				System.out.println("Started!");
			} else {
				System.out.println("Waiting!");
			}
			while (!members.isEmpty()) {
				Player p = members.poll();
				System.out.println(p.level + " " + p.nickname);
			}
		}
	}

	static class Player implements Comparable<Player> {
		String nickname;
		int level;

		public Player(String nickname, int level) {
			super();
			this.nickname = nickname;
			this.level = level;
		}

		@Override
		public int compareTo(Player o) {
			return this.nickname.compareTo(o.nickname);
		}
	}
}