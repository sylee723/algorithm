package boj.s5;

import java.util.Scanner;

//재귀함수가 뭔가요?
public class Boj17478 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		System.out.println(chatbot(n, 0));
	}

	public static String chatbot(int num, int now) {
		StringBuilder sb = new StringBuilder();
		String tab = "";
		for (int i = 0; i < now; i++)
			tab += "____";
		sb.append(tab + "\"재귀함수가 뭔가요?\"\n");
		if (num == now) {
			sb.append(tab + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
		} else {
			sb.append(tab + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
			sb.append(tab + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
			sb.append(tab + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
			sb.append(chatbot(num, now + 1));
		}
		sb.append(tab + "라고 답변하였지.\n");
		return sb.toString();
	}
}
