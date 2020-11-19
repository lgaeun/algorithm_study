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
		
		// �� ���Һ� ����� ���
		for(int i=0; i<n; i++) {
			int cursur=0;
			int j=0;
			while (j<pwd[i].length()) {
				switch (pwd[i].charAt(j)) {
				case '<':
					if (cursur>0) cursur--;				//Ŀ���� ���� �տ� �ִ� ��찡 �ƴϸ� �ϳ� ����
					pwd[i].deleteCharAt(j);
					break;
				case '>':
					if (cursur<pwd[i].length() && cursur<j) cursur++;	//Ŀ���� ���� �ڿ��ִ� ��찡 �ƴϸ� �ϳ� ����
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


