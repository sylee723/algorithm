package boj.g5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj2023_신기한_소수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> result = getNextPrime(0);
		int d = 1; // result 리스트에 있는 소수의 자리수
		while (d < N) {
			List<Integer> nextResult = new ArrayList<>();
			for (int i = 0; i < result.size(); i++) {
				for (int n : getNextPrime(result.get(i))) {
					nextResult.add(n); // 자리수가 하나 큰 소수 구함
				}
			}
			result = nextResult;
			d++;
		}
		for (int r : result)
			System.out.println(r);
	}

	static boolean isPrime(int num) {
		if (num < 2)
			return false;
		int i = 2;
		while (num > i) {
			if (num % i == 0)
				return false;
			i++;
		}
		return true;
	}

	static List<Integer> getNextPrime(int num) {
		List<Integer> prime = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			if (isPrime(num * 10 + i))
				prime.add(num * 10 + i);
		}
		return prime;
	}
}
