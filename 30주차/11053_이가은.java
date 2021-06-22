import java.io.*;

public class _11053 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = stoi(br.readLine().split(" "));
		int[] dp = new int[n];
		
		for(int i = 0; i < n; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) { 	//0~i 이전 숫자들과 모두 비교
				if(a[j] < a[i] && dp[i] < dp[j] + 1)	
					dp[i] = dp[j] + 1;
			}
		}
		
		int max = 0;
		for(int i = 0; i < n; i++) max = Math.max(max, dp[i]);
		System.out.println(max);
	}
	
	static int[] stoi(String[] s) {
		int[] res = new int[s.length];
		for(int i = 0; i < s.length; i++) res[i] = Integer.parseInt(s[i]);
		return res;
	}

}

// 14: 0~i 이전 숫자들과 모두 비교
// i 번째에서 가장 긴 증가하는 부분수열이 중간부터 시작하는 수열일 수도 있기 때문에 모두 비교해줘야함 
