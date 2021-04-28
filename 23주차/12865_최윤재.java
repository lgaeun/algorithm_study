package tmp;
import java.util.*;
import java.io.*;
public class _12865_최윤재_평범한배낭 {
	
	static int num;
	static int max_weight;
	static int[] weight;	//무게 저장 배열
	static int[] value;		//가치 저장 배열
	static int[][] dp;		//dp배열
	
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
		////////////////////////////////////////////////////입력
		for(int i=1; i<=max_weight; i++) {		//가능한 최대무게에 이를 때까지 수행
			for(int j=1; j<=num; j++) {			//각 물건에 대해 수행
				if(i>=weight[j]) {	//해당 물건이 들어갈 수 있을 때
					dp[i][j] = Math.max(dp[i][j-1], dp[i-weight[j]][j-1]+value[j]);	//이 물건이 안들어가는 경우 중 최고값인 dp[i][j-1]과 이 물건이 들어갔을 때 최대값 중 더 큰 거 고름
				}
				else {
					dp[i][j] = dp[i][j-1];	//해당 물건이 무거워서 못들어가면 앞의 값 그대로 받아오기
				}
			}
		}
		System.out.println(dp[max_weight][num]);
	}

}
