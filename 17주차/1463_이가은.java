import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		
		dp[1] = 0;
		for(int i = 2; i <= n; i++) {
			dp[i] = dp[i-1]+1;    //i에서 1빼는 경우 
			if(i%2==0 && dp[i] > dp[i/2] + 1)   //i가 2로 나누어떨어질때, 2로 나누는 경우 
				dp[i] = dp[i/2] + 1;
			if(i%3==0 && dp[i] > dp[i/3] + 1)   //i가 3으로 나누어떨어질때, 3으로 나누는 경우
				dp[i] = dp[i/3] + 1;
		}
		System.out.println(dp[n]);
	}
}
