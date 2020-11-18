package week2;
import java.util.*;
import java.io.*;

public class Yoonjae_5397_1 {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		int n= sc.nextInt();
		sc.nextLine();
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder outcome = new StringBuilder();
		
		Stack<Character> front = new Stack<Character>();
		Stack<Character> back = new Stack<Character>();
		
		
		for(int i=0; i<n;i++) {
			String pwd = bf.readLine();
			for(int j=0; j<pwd.length();j++) {
				char check = pwd.charAt(j);
				switch (check) {
				case '<':
					if (!front.isEmpty()) {
						back.push(front.pop());				//Ŀ���� ���� �տ� �ִ� ��찡 �ƴϸ� �ϳ� ����
					}
					break;
				case '>':
					if (!back.isEmpty()) front.push(back.pop());	//Ŀ���� ���� �ڿ��ִ� ��찡 �ƴϸ� �ϳ� ����
					break;
				case '-':
					if (!front.isEmpty()) {
						front.pop();
					}
					break;
				default:
					front.push(check);
				}
			}
			while(!front.isEmpty()) {
				outcome.append(front.remove(0));
			};
			while(!back.isEmpty()) {
				outcome.append(back.pop());
			}
			outcome.append("\n");
		}
		System.out.println(outcome);
	}
}


