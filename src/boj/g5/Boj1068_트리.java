package boj.g5;

import java.util.Scanner;
import java.util.Stack;

public class Boj1068_트리 {
	static int N;
	static int[] parent;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		parent = new int[N];
		
		for (int i = 0; i <N; i++) {
			parent[i] = sc.nextInt();
		}
		
		int remove = sc.nextInt();
		findAndRemove(remove);
		
		int leaf_cnt = 0;
		for (int i =0; i<N; i++) {
			
		}
	}
	
	static void findAndRemove(int p) {
		for (int i = 0; i<N; i++) {
			if (parent[i] == p) {
				parent[i] = -2;
				findAndRemove(i);
			}
		}
	}
}
