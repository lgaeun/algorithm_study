import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr, ans;
	static boolean[] visit;
	static int n, max = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	arr = new int[n];
    	ans = new int[n];
    	visit = new boolean[n];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i = 0;  i< n; i++) arr[i] = Integer.parseInt(st.nextToken());
    	
    	dfs(0);
    	System.out.println(max);

	}
	static void dfs(int depth) {
		if(depth == n) {
			int sum = 0;
			for(int i = 1; i < n; i++) sum += Math.abs(ans[i-1]-ans[i]);
			max = Math.max(max, sum);
		}
		
		for(int i = 0; i < n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				ans[depth] = arr[i];
				dfs(depth+1);
				visit[i] = false;
			}
		}
	}

}
