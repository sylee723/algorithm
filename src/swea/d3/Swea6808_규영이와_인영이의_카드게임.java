package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea6808_규영이와_인영이의_카드게임 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] kyuyoungCards = new int[9];
			for(int i=0; i<9; i++) {
				kyuyoungCards[i] = Integer.parseInt(st.nextToken());
				
			}
			int[] inyoungCards = new int[9];
			
			System.out.println("#"+t);
		}
	}
}
