package week7;
import java.util.*;
public class ������_5525 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();				//������ O ����
		int N_len = 2*N+1;					//���� ����
		int M = sc.nextInt();				//�Է� ���ڿ� ����
		int result=0;						//���� ��� ����
		LinkedList<Integer> lst = new LinkedList<Integer>();	//�� �κ� ���Ϻ� �� ����� ����
		
		sc.nextLine();
		String line = sc.nextLine();
		
		for(int i=0; i<M; i++) {			
			int count=1;					//������ ��Ÿ�� �κ��� ���� ���� ����
			if(line.charAt(i)=='I') {
				while(i<line.length()-2) {
					if(line.charAt(i)!=line.charAt(i+1)) {		//�հ� �ٸ� char�ΰ�� (I->O �Ǵ� O->I) ���� ���� �ϳ� ����
						count++;
						i++;				//�ε��� ����
					}
					else break;				//������ ������ while�� break
				}
			}
			if (count>=N_len) lst.add((count-(N_len))/2+1);		//��Ÿ�� �κ� ���ϳ��� ���� ������ � ���ԵǴ��� ����ؼ� lst�� ����
		}
		
		for(int i=0; i<lst.size(); i++) {	//lst�� �� ���ؼ� ���� ��� ����
			result+=lst.get(i);
		}
		System.out.println(result);
	}

}

////IOIOI
