import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[301];
		int dp[] = new int[301];
		
		for(int i = 1; i <= n; i++) 
			arr[i] = Integer.parseInt(br.readLine());
		
		//초기값 
		dp[1] = arr[1];
		dp[2] = arr[2]+dp[1];		
		//전계단 밟는 경우, 전전계단 밟는 경우
		for(int i = 3; i <= n; i++) 
			dp[i] = max(dp[i-3] + arr[i] + arr[i-1], dp[i-2] + arr[i]);
		
		System.out.print(dp[n]);	
	}
	
	static int max(int a, int b) {
		return a > b ? a : b;
	}
    
}
