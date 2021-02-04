import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [][]map = new int[n][n];
		long [][]dp = new long[n][n];
		
		StringTokenizer st; //입력 
		for(int i = 0; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = 1;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i==n-1 && j==n-1) break;
				if(dp[i][j] != 0) {
					int step = map[i][j];
					if(i+step < n) dp[i+step][j] += dp[i][j];
					if(j+step < n) dp[i][j+step] += dp[i][j];
					
				}
			}
		}
		System.out.print(dp[n-1][n-1]);	
	}

}