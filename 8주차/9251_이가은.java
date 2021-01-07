import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		int[][] dp = new int[s2.length()+1][s1.length()+1];

		for(int i = 1; i <= s2.length(); i++) {
			for(int j = 1; j <= s1.length(); j++) {
				
				
				if(s2.charAt(i-1) == s1.charAt(j-1)) 
					dp[i][j] = dp[i-1][j-1] + 1;
				else
					dp[i][j] = max(dp[i][j-1], dp[i-1][j]);	
			}
		}		
		System.out.print(dp[s2.length()][s1.length()]);
	}
	
	static int max(int a, int b) {
		return a > b? a : b;
	}
	
}