package week2;

import java.util.*;

public class YJ_2447 {
	
	public static StringBuilder result=new StringBuilder();	//�Ź� System.out.print()�ϴϱ� �ð� �ʰ��� ���� Stringbuilder�� ���ڿ� ����
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();					//n�� ������ ����,���� ����
		
		for (int i =0; i<n ; i++) {
			for(int j=0; j<n; j++) {
				pattern(i,j,n);
			}
			result.append("\n");
		}
		System.out.println(result);
	}
	
	public static void pattern(int i, int j, int n) {
		if((i/n)%3==1 && (j/n)%3==1) {			// �� ��� �κ��� *�� ������ �ʱ� ������ i�� j���� ��� i�� j�� n���� ���� ��� ���� 1�� �Ǹ� ���� ���� ���ƾ� ��.
			result.append(" ");
		}
		else {
			if (n/3==0) {
				result.append("*");
			}
			else {
				pattern(i,j,n/3);
			}
		}
	}
}