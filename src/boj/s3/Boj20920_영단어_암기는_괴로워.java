package boj.s3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj20920_영단어_암기는_괴로워 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String voca = br.readLine();

			if (voca.length() < M)
				continue;

			int count = map.getOrDefault(voca, 0);
			map.put(voca, count + 1);
		}

		ArrayList<Voca> vocaList = new ArrayList<>();
		for (String voca : map.keySet()) {
			vocaList.add(new Voca(map.get(voca), voca.length(), voca));
		}

		Collections.sort(vocaList, new Comparator<Voca>() {
			@Override
			public int compare(Voca o1, Voca o2) {
				if (o1.count != o2.count)
					return -(o1.count - o2.count);
				if (o1.size != o2.size)
					return -(o1.size - o2.size);
				return o1.str.compareTo(o2.str);
			}
		});

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (Voca voca : vocaList) {
			bw.write(voca.str);
			bw.write("\n");
		}

		bw.flush();
		bw.close();
	}

	static class Voca {
		int count;
		int size;
		String str;

		public Voca(int count, int size, String str) {
			this.count = count;
			this.size = size;
			this.str = str;
		}
	}
}
