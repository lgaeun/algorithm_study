package dynamic;
import java.io.*;
import java.util.*;

public class _2565 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());  	// n <= 100
		
		int[][] arr = new int[n][2];		       //전기줄 저장 
		int[] dp = new int [n];
		
		for(int i  = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//전기줄 A 기준 오름차순 정렬 
		Arrays.sort(arr, new Comparator<int[]>() {
			
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		
		//max 전기줄 개수 구하기
		int maxLine = 1;
		for(int i = 0; i < n; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(arr[j][1] < arr[i][1])
					dp[i] = Math.max(dp[i], dp[j]+1);
			}
			maxLine = Math.max(dp[i], maxLine);
		}
		
		System.out.print(n-maxLine);

	}

}