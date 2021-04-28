package tmp;
import java.util.*;
import java.io.*;
public class _12865_������_����ѹ賶 {
	
	static int num;
	static int max_weight;
	static int[] weight;	//���� ���� �迭
	static int[] value;		//��ġ ���� �迭
	static int[][] dp;		//dp�迭
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		num = Integer.parseInt(st.nextToken());
		max_weight = Integer.parseInt(st.nextToken());
		dp = new int[max_weight+1][num+1];
		weight = new int[num+1];
		value = new int[num+1];
		for(int i=1; i<=num; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		////////////////////////////////////////////////////�Է�
		for(int i=1; i<=max_weight; i++) {		//������ �ִ빫�Կ� �̸� ������ ����
			for(int j=1; j<=num; j++) {			//�� ���ǿ� ���� ����
				if(i>=weight[j]) {	//�ش� ������ �� �� ���� ��
					dp[i][j] = Math.max(dp[i][j-1], dp[i-weight[j]][j-1]+value[j]);	//�� ������ �ȵ��� ��� �� �ְ��� dp[i][j-1]�� �� ������ ���� �� �ִ밪 �� �� ū �� ��
				}
				else {
					dp[i][j] = dp[i][j-1];	//�ش� ������ ���ſ��� ������ ���� �� �״�� �޾ƿ���
				}
			}
		}
		System.out.println(dp[max_weight][num]);
	}

}
