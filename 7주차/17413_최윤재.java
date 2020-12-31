package week7;
import java.util.*;
public class ������_17413 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String line = sc.nextLine();				//�Է¹��� string
		Stack stack = new Stack();					//���� �̿�
		StringBuilder sb = new StringBuilder();		//��� ������ StringBuilder
		
		for(int i=0; i<line.length(); i++) {		//index���� Ȯ��
			switch(line.charAt(i)) {
			case '<':								//�ش� �ε����� '<'�� ���
				while(!stack.isEmpty()) sb.append(stack.pop());		//�������� ������ ������ ������ ���
				while(true) {
					if(line.charAt(i)=='>') {		//�������� '>'�� ���� ��� while�� ��������
						sb.append('>');
						break;
					}
					sb.append(line.charAt(i++));	//'>'�� ���� �������� ���������� ���
				}
				break;
			case ' ':								//���Ⱑ ���� ���
				while(!stack.isEmpty()) sb.append(stack.pop());	//���� ���� ������ ���
				sb.append(' ');					
				break;
			default:								//�׳� ���ڿ� ���� ��쿡�� stack�� ����
				stack.add(line.charAt(i));
				break;
			}
		}
		while(!stack.isEmpty()) {					//stack���� ������ ����ϱ�
			sb.append(stack.pop());
		}
		System.out.println(sb);
	}
}





//�ܾ������ 2
