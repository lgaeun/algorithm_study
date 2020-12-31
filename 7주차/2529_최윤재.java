//��Ʈ��ŷ �̿�

package week7;
import java.util.*;
public class ������_2529 {

	static char[] input;					//<,> ����
	static int n;							//�ε�ȣ ����
	static int[] visited = new int[10];		//�ش� ���� ����� �Ƚ���� ����
	static String max = "0";				//�ʱ� max �� ������ ���� string
	static String min = "9";				//�ʱ� min �� ������ ���� string
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();		
		sc.nextLine();
		input = new char[n];
		
		for(int i=0; i<n; i++) {				//<,> �Է� �ޱ�
			input[i]=sc.next().charAt(0);
			max+=i+1;
			min+=8-i;
		}
//////////////////////////////////////////////////������� �Է�
		
		for(int i=0; i<10; i++) {					//DFS �̿�
			visited[i]=1;							//���� �տ� �� ����
			for(int j=0; j<10; j++) {				//�ι�° �տ� �� ����
				if(i!=j) {							//�� ���ڰ� ���� ���� ��쿡�� Ž�� ���� (�� ���� �ѹ����� �� �� �����Ƿ�)
					visited[j]=1;					//�ι�° ���� �̿��ߴٰ� ǥ��
					promising(i,j,0,""+i+j);		//DFS ����
					visited[j]=0;					//�ι�° ���� �̿��ߴٴ� ǥ�� Ǯ��
				}
			}
			visited[i]=0;							//ù��° ���� �̿��ߴٴ� ǥ�� Ǯ��
		}
		
		System.out.println(max);					//��� ���
		System.out.println(min);
	}
	
	
	
	public static void promising(int front, int back, int loc, String tmp) {		//DFS �ڵ� �� promising���� Ȯ��
		char c = input[loc];												//�̹��� Ȯ���� �ε�ȣ ��ġ
		boolean flag = false;												//�ε�ȣ�� ���ڵ��� ���� ������ ���� true�� �ٲ�
		if(c=='>' && front>back) flag = true; 								// > �ε�ȣ�� ���
		else if(c=='<' && front<back) flag = true;							// < �ε�ȣ�� ���
		if(flag && loc==n-1) {												//������ ���� �ε�ȣ ���谡 �ùٸ��� ������ ������ Ž���� ���
			if (Long.parseLong(tmp)>=Long.parseLong(max)) max=tmp;			//max �� ������Ʈ (Integer.parseInt()���� ������ �Ѿ�� ��� ������ ��Ÿ�� ������)
			if (Long.parseLong(tmp)<Long.parseLong(min)) min=tmp;			//min �� ������Ʈ
			return;
		}
		if(flag) {															//flag�� true���� promising �� ��� ���� ��� Ž��
			for(int i=0; i<10; i++) {
				if(visited[i]==0) {											//���� �湮���� ���� ���ڸ� �̿�
					visited[i]=1;											//�湮 ǥ��
					promising(back, i, loc+1, tmp+i);						//DFS ����	
					visited[i]=0;											//�湮 ǥ���ߴ� �� Ǯ���ֱ�
				}
			}
		}
	}
}


/////�ε�ȣ
