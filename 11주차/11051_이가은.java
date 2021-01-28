import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int dp[][] = new int[n+1][n+1];
		
		dp[0][0] = 1;
		
		for(int i = 1; i <= n; i++) {
			dp[i][0] = 1;
			for(int j = 1; j <= i; j++) {
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 10007;
			}
		}
		System.out.print(dp[n][k]);				
	}
}