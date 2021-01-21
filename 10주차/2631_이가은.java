import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n+1];
        int [] dp = new int[n+1];  //증가수열길이 
       
        for(int i = 1; i <= n; i++)
            arr[i] = sc.nextInt();
        
        for(int i = 1; i <= n; i++) {
        	dp[i] = 1;
        	for(int j = 1; j < i; j++) {
        		if(arr[j] < arr[i] && dp[i] <= dp[j])
        			dp[i] = dp[j] + 1;
        	}
        }
        Arrays.sort(dp);
        System.out.println(n-dp[n]); // 전체길이 - 이미 순서대로 서있는 애들의 수(LIS길이) = 움직여야하는 애들 최소 수
	}

}

