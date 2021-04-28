import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int k = Integer.parseInt(st.nextToken());
    	int[] W = new int[n+1];
    	int[] V = new int[n+1];
    	int[]dp = new int[k+1];	// dp[i번 째 아이템]
  
    	for(int i = 1; i <= n; i++) {
    		st = new StringTokenizer(br.readLine());
    		W[i] = Integer.parseInt(st.nextToken());
    		V[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	// knapsack algorithm, bottom-up 방식 
    	for(int i = 1; i <= n; i++) { //i번째 배낭에 대해서 
    		for(int j = k; j - W[i] >= 0; j--) {	//무게: k부터 시작하여, 담을 수 있는 무게가 한계치를 넘지 않을 때까지 반복 
    			dp[j] = Math.max(dp[j], dp[j - W[i]] + V[i]);
    		}
    	}
    	System.out.println(dp[k]);
	}

}
