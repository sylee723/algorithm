package swea.d3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Swea2805 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			int[][] board = new int[n][n];
			for(int i=0; i<n; i++) {
				String line = br.readLine();
				for(int j=0; j<n; j++) {
					board[i][j] = line.charAt(j) - '0';
				}
			}
			
			int middle = n/2;
			int result = 0;
			for(int i= 0; i<=middle; i++) { // 두 행씩 더함(맨 위와 맨 아래)
				for(int j=middle - i; j <= middle + i; j++) {
					if (i == middle) // 가운데 행은 한 행만 더함
						result += board[i][j];
					else
						result += (board[i][j] + board[n-i-1][j]);
				}
			}
			
			System.out.println("#"+test_case+" "+result);
		}
	}
}
