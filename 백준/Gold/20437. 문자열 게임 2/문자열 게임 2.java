import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		ArrayList<Integer>[] idxList = new ArrayList['z' - 'a' + 1];
		for (int i = 0; i < idxList.length; i++) {
			idxList[i] = new ArrayList<>();
		}

		for (int t = 0; t < T; t++) {
			String W = br.readLine();
			int K = Integer.parseInt(br.readLine());

			for (int i = 0; i < idxList.length; i++) {
				idxList[i].clear();
			}

			for (int s = 0; s < W.length(); s++) {
				char ch = W.charAt(s);
				idxList[ch - 'a'].add(s);
			}

			boolean find = false;
			int minLen = W.length() + 1;
			int maxLen = 0;
			for (int i = 0; i < idxList.length; i++) {
				if (idxList[i].size() < K) {
					continue;
				}

				find = true;
				for (int j = 0; j + K - 1 < idxList[i].size(); j++) {
					int left = idxList[i].get(j);
					int right = idxList[i].get(j + K - 1);

					minLen = Math.min(minLen, right - left + 1);
					maxLen = Math.max(maxLen, right - left + 1);
				}
			}

			if (find) {
				sb.append(minLen);
				sb.append(" ");
				sb.append(maxLen);
			} else {
				sb.append("-1");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}