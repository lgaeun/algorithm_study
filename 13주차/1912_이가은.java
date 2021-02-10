import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int [n];
		int[] arr = new int[n];
		int sum = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = arr[0];
		sum += arr[0];
		
		for(int i = 1; i < n; i++) { 
			dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
			sum = Math.max(sum, dp[i]);
		}
		System.out.print(sum);
	}

}