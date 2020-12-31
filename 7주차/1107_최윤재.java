package week7;
import java.util.*;
public class ������_1107 {

	static int target;									//��ǥ ä��
	static int broken;									//���峭 ����
	static int[] number = new int[10];					//���峭 ä���� ����
	static int min;										//���� ���
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		target=sc.nextInt();
		broken=sc.nextInt();
		for(int i=0; i<broken; i++) {					//���峭 ��ȣ �迭�� 0���� �ٲ�
			number[sc.nextInt()]=-1;
		}	
		min = Math.abs(target - 100);					//�켱 target�� 100�� ä���� +,-��ư���� ������ ���� �ּҷ� �����س���		

		if(target==100) System.out.println(0);			//��ǥ ä���� 100�ΰ��
		else System.out.println(check());				//��ǥ ä���� 100�� �ƴ� ���			
	}
	
	public static int check() {
		boolean flag=true;
		String tmp="";
		for(int i=0; i<=5000000; i++) {					//��� ��� Ȯ��
			flag=true;
			tmp=""+i;
			for(int j=0; j<tmp.length();j++) {
				if(number[tmp.charAt(j)-'0']==-1) {		//���峭 ��ư ������ flag�� false��
					flag=false;
					break;
				}
			}
			if(flag) {
				min=Math.min(min, Math.abs(i-target)+tmp.length());		//minimum �� ������Ʈ
			}
		}
		return min;
	}
	
}
