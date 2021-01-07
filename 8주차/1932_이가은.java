import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[500][500];
		
		for(int i = 0; i < n; i++) { 
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j <= i; j++)
				dp[i][j] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				if (j == 0)
					dp[i][j] += dp[i-1][j];
				else if (j == i)
					dp[i][j] += dp[i-1][j-1];
				else
					dp[i][j] = max(dp[i-1][j]+dp[i][j], dp[i-1][j-1]+dp[i][j]);
			}
			
		}
		
		int max = dp[n-1][0];
		for(int i = 1; i < n; i++) {
			max = max(max, dp[n-1][i]);
		}
		System.out.print(max);
	}
	
	static int max(int a, int b) {
		return a > b ? a : b;
	}

}