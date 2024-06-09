package boj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj22233_가희와_키워드 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Set<String> memo = new HashSet<>();
		for (int i = 0; i < N; i++) {
			String keyword = br.readLine();
			memo.add(keyword);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String[] blog = br.readLine().split(",");
			for (int j = 0; j < blog.length; j++) {
				memo.remove(blog[j]);
			}

			sb.append(memo.size()).append("\n");
		}

		System.out.println(sb.toString());
	}
}
