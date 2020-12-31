package week7;
import java.util.*;
public class ������_1759 {
	
	static int L;
	static int C;
	static char[] alphabet;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();							//��ȣ ����
		C = sc.nextInt();							//��ȣ�� �� �� �ִ� ���ĺ� ����
		alphabet=new char[C];						//��� ������ ���ĺ� ������ �迭
		
		for(int i=0; i<C; i++) {
			alphabet[i]=sc.next().charAt(0);
		}
		//////////////////////////////////////////////������� �Է�
		Arrays.sort(alphabet);						//���ĺ� ������� ����
		
		for(int i=0; i<C; i++) {					//DFS �̿�, ��Ʈ��ŷ
			if(isVowel(alphabet[i]))				//������ ���, isVowel�� �ش� character�� �������� Ȯ���ϴ� �Լ�		
				promising(i,1,""+alphabet[i]);		//���� ������ 1�� �����ϰ� DFS
			else									//������ �ƴ� ���
				promising(i,0,""+alphabet[i]);
		}
		
		System.out.println(result);					//��� ���
	}
	
	
	
	static boolean isVowel(char c) {				//�������� Ȯ���ϴ� �Լ�
		if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u') return true;
		return false;
	}
	
	static void promising(int start, int vowel, String tmp) {		//DFS. ���� ���� ���ĺ��� ���� ����, ������� Ȯ���� string�� ���ڷ� ����
		if(tmp.length()==L && vowel>0 && L-vowel>=2) {				//string�� �ϼ� �Ǿ��� ������ �Ѱ� �̻��̸� ������ �ΰ� �̻��� ��쿡�� result�� �߰�
			result.append(tmp+"\n");
			return;
		}
		else 
		for(int i=start+1; i<C; i++) {								//���� string�� �ϼ����� ���� ��쿡�� ���� alphabet�� string�� �߰��� DFS ����
			if(isVowel(alphabet[i])) promising(i, vowel+1,tmp+alphabet[i]);		//������ ���
			else promising(i,vowel,tmp+alphabet[i]);							//������ �ƴ� ���
		}
	}
}
