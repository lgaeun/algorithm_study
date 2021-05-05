import java.io.*;
import java.util.*;

public class Main {
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		dp = new int[D+1][2]; //dp[i][0]: i일 일 때, 첫째 날 떡이 반복된 횟수, dp[i][1]: i일 일 때, 둘째 날 떡이 반복된 횟수
		for(int i = 0; i <= D; i++) Arrays.fill(dp[i], -1);
		
		dp[0][1] = 0;
		dp[0][0] = 1;
		dp[1][0] = 0;
		dp[1][1] = 1;
		
		fib(D);
		
		int a = 1, b = 0;
		boolean flag = false;
		while(true) {
			for(int i = a; i <= N - dp[D][0]*a; i++){	
				if(a * dp[D-1][0] + i * dp[D-1][1] == N) {
					flag = true;
					b = i;
					break;
				}
			}
			if(flag) break;
			else a++;
		}
		System.out.println(a+"\n"+b);
		
	}
	static int[] fib(int n) {
		if(dp[n][0] == -1 || dp[n][1] == -1 ) {
			dp[n][0] = fib(n-1)[0] + fib(n-2)[0];
			dp[n][1] = fib(n-1)[1] + fib(n-2)[1];
		}
		return dp[n];
	}

}
