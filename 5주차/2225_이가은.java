package dynamic;

import java.util.Scanner;

public class _2225 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		long[][] arr = new long [201][201];
		
		// 이항계수 
		for(int i = 0; i <= n+k; i++) {
			for(int j = 0; j <= i; j++) {
				if(j==0 || j==i) arr[i][j] = 1;
				else arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
			}	
		}
		System.out.print(arr[n+k-1][n] % 1000000000);
	}
}