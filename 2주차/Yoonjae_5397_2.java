package week2;
import java.util.*;

public class Yoonjae_5397_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n= sc.nextInt();
		sc.nextLine();
		
		StringBuilder[] pwd = new StringBuilder[n];

		for(int i=0; i<n; i++) {
			pwd[i]=new StringBuilder(sc.nextLine());
		}
		
		// 각 원소별 결과값 출력
		for(int i=0; i<n; i++) {
			int cursur=0;
			int j=0;
			while (j<pwd[i].length()) {
				switch (pwd[i].charAt(j)) {
				case '<':
					if (cursur>0) cursur--;				//커서가 가장 앞에 있는 경우가 아니면 하나 감소
					pwd[i].deleteCharAt(j);
					break;
				case '>':
					if (cursur<pwd[i].length() && cursur<j) cursur++;	//커서가 가장 뒤에있는 경우가 아니면 하나 증가
					pwd[i].deleteCharAt(j);
					break;
				case '-':
					if (cursur>0) {
						pwd[i].deleteCharAt(j);
						pwd[i].deleteCharAt(cursur-1);
						cursur--;
						j--;
					}
					break;
				default:
					pwd[i].insert(cursur, pwd[i].charAt(j));
					pwd[i].deleteCharAt(j+1);
					cursur++;
					j++;
				}
			}
			System.out.println(pwd[i]);
		}
	}
}


