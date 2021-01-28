import java.util.*;
import java.io.*;

public class simple {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int []arr = new int [n+1];
		int []dp = new int [n+1];
		
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		//초기값 설정 
		dp[1] = arr[1];
		if(n > 1)	//n=1인 경우도 있을 수 있기 때문 
			dp[2] = dp[1]+arr[2];
		
		for(int i = 3; i <= n; i++) {
			// 1. i-1번째 값을 선택하지 않는 경우와, 선택하는 경우 중 큰 것 + arr[i]가 일단 dp[i]의 후
			// 2. dp[i-1]이 최대라는 보장이 없기 때문에 위의 값과 dp[i-1]비교를 한 번 더 해줘야 함 
			dp[i] = Math.max(dp[i-1], arr[i]+Math.max(dp[i-2], dp[i-3]+arr[i-1])) ; 
		}
		
		System.out.print(dp[n]);	
		
	}
	
}
